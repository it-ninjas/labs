#!/usr/bin/env bash
set -euo pipefail

# -----------------------------------------------------------------------------
# Latest Changes Generator (pro content/<x>/)
# - erzeugt/aktualisiert content/<x>/about/latest-changes.md
# - Abschnitt pro Tag: Release Notes + Seiten-Änderungen (content/**/*.md)
# - Kein Eintrag, wenn keine relevanten Änderungen
# - Kein Backfill beim ersten Lauf (nur aktueller Commit)
# - Default-Branch wird automatisch erkannt, wenn nicht übergeben
# - Linktext: Breadcrumb aus linkTitle/title von _index.md bzw. Seiten
# - Links: relativ zum Jahresordner (../docs/.../seite/)
#
# Aufruf:
#   .github/scripts/update-latest-changes.sh "<TAG_NAME>" [<MAIN_REF>] [<EXPLICIT_RANGE>]
#   Beispiel lokal:
#     .github/scripts/update-latest-changes.sh "20250902-0651-123" origin/main
# -----------------------------------------------------------------------------

TIMEZONE="Europe/Zurich"

# Inputs
TAG_NAME="${1:-}"        # z.B. 20250902-0651-123 (für Abschnittstitel)
MAIN_REF="${2:-}"        # z.B. origin/main (leer => Auto-Detect)
EXPLICIT_RANGE="${3:-}"  # optionaler Git-Range (z.B. abc^..abc), leer => auto

# ---- Git vorbereiten --------------------------------------------------------
git fetch --tags origin >/dev/null 2>&1 || true
git fetch origin >/dev/null 2>&1 || true

# Default-Branch automatisch ermitteln, falls nicht übergeben
if [[ -z "${MAIN_REF}" ]]; then
  DEFAULT_BRANCH="$(git remote show origin | awk '/HEAD branch/ {print $NF}')"
  [[ -z "${DEFAULT_BRANCH}" ]] && DEFAULT_BRANCH="main"
  MAIN_REF="origin/${DEFAULT_BRANCH}"
fi
echo ">> Verwende Branch: ${MAIN_REF}"

MAIN_SHA="$(git rev-parse "${MAIN_REF}")"

# ---- Range bestimmen --------------------------------------------------------
if [[ -n "${EXPLICIT_RANGE}" ]]; then
  RANGE="${EXPLICIT_RANGE}"
else
  LAST_TAG="$(git tag --sort=-creatordate | head -n1 || true)"
  if [[ -z "${LAST_TAG}" ]]; then
    # Kein Tag → nur aktueller Commit (kein Backfill)
    if git rev-parse "${MAIN_SHA}^" >/dev/null 2>&1; then
      RANGE="${MAIN_SHA}^..${MAIN_SHA}"
    else
      RANGE="${MAIN_SHA}..${MAIN_SHA}"
    fi
  else
    RANGE="${LAST_TAG}..${MAIN_SHA}"
  fi
fi
echo ">> Vergleiche Range: ${RANGE}"

HUMAN_DATE="$(TZ=$TIMEZONE date +'%Y-%m-%d %H:%M %Z')"

# ---- RELEASE-NOTE Zeilen global einsammeln ----------------------------------
RELEASE_NOTES="$(
  git log --no-merges --format='%B' "$RANGE" | grep -E '^RELEASE-NOTE:' || true
)"
RELEASE_NOTES_TRIMMED="$(
  printf "%s" "$RELEASE_NOTES" | sed -E 's/^RELEASE-NOTE:\s*//g' || true
)"

# ---- Änderungen im content/-Baum sammeln ------------------------------------
# Normalisiere Name-Status:
# - A p
# - M p
# - D p
# - R* p_old p_new  → als "M p_new" behandeln
CHANGES_RAW="$(
  git diff --name-status "$RANGE" -- content \
  | awk '
      $1=="A" {print "A\t"$2}
      $1=="M" {print "M\t"$2}
      $1=="D" {print "D\t"$2}
      $1 ~ /^R[0-9]+$/ {print "M\t"$3}
    ' \
  | grep -E '\.md($|\s)' || true
)"

# Self-update ausschließen: latest-changes.md nicht listen
CHANGES_RAW="$(
  printf "%s\n" "$CHANGES_RAW" \
  | awk '$2 !~ /\/about\/latest-changes\.md$/'
)"

# Wenn es weder Release Notes noch Änderungen gibt → kein Eintrag
if [[ -z "${RELEASE_NOTES_TRIMMED}${CHANGES_RAW}" ]]; then
  echo ">> Keine Release Notes oder Seitenänderungen – kein Eintrag erzeugt."
  exit 0
fi

# ---- Helper: Titel aus Frontmatter lesen ------------------------------------
# Liest aus erster '--- ... ---' Frontmatter 'linkTitle:' oder 'title:' (erste gefundene)
get_title_from_md() {
  local file="$1"
  if [[ -f "$file" ]]; then
    awk '
      BEGIN { inheader=0 }
      /^---[ \t]*$/ { if(inheader==0){inheader=1;next}else{exit} }
      inheader==1 && ($1=="linkTitle:" || $1=="title:") {
        $1="";
        sub(/^[ \t]+/,"",$0);
        print $0;
        exit
      }
    ' "$file"
  fi
}

# Entfernt CR, trimmt Spaces, strippt '...'/ "..."
sanitize_title() {
  local s="$1"
  s="${s//$'\r'/}"
  s="${s#"${s%%[![:space:]]*}"}"
  s="${s%"${s##*[![:space:]]}"}"
  if [[ "$s" == \"*\" && "$s" == *\" ]]; then
    s="${s:1:-1}"
  elif [[ "$s" == \'*\' && "$s" == *\' ]]; then
    s="${s:1:-1}"
  fi
  printf '%s' "$s"
}

# ---- Helper: Breadcrumb-Link mit RELATIV-URL "../..." bauen -----------------
# Gibt eine Markdown-Zeile '  - [Text](../target/)' zurück.
# Bei gelöschten Dateien (nicht mehr vorhanden): nur Text ohne Link.
# Parameter: 1) full path unter content/..., 2) YEAR (z.B. 2025)
make_link_line() {
  local full="$1"         # content/2025/docs/.../(file.md|_index.md)
  local year="$2"
  local rel="${full#content/}"             # 2025/docs/...
  local rel_under_year="${rel#${year}/}"   # docs/...

  # Ziel-URL (Directory-URL mit trailing slash)
  local target
  local target_exists=true
  if [[ "$rel_under_year" == */_index.md ]]; then
    target="${rel_under_year%/_index.md}/"
    [[ -d "content/${year}/${rel_under_year%/_index.md}" ]] || target_exists=false
  else
    target="${rel_under_year%.md}/"
    [[ -f "content/${year}/${rel_under_year}" ]] || target_exists=false
  fi

  # Breadcrumb-Titel bauen (ohne Jahr-Segment)
  local segments=()
  local pathSoFar="content/${year}"
  IFS='/' read -ra parts <<< "$rel_under_year"

  for idx in "${!parts[@]}"; do
    local part="${parts[$idx]}"

    # _index.md nicht als sichtbares Segment anzeigen
    if [[ "$part" == "_index.md" ]]; then
      continue
    fi

    pathSoFar="$pathSoFar/$part"

    if [[ "$part" == *.md ]]; then
      # Seitentitel aus der Datei
      local title
      title="$(get_title_from_md "$pathSoFar")"
      title="$(sanitize_title "$title")"
      [[ -z "$title" ]] && title="${part%.md}"
      segments+=("$title")
    else
      # Ordner → Titel aus _index.md wenn vorhanden, sonst Ordnername
      local idxfile="$pathSoFar/_index.md"
      local title=""
      if [[ -f "$idxfile" ]]; then
        title="$(get_title_from_md "$idxfile")"
        title="$(sanitize_title "$title")"
      fi
      [[ -z "$title" ]] && title="$part"
      segments+=("$title")
    fi
  done

    # Breadcrumb-Text mit " / " als Trenner
  local text
  text="$(printf ' / %s' "${segments[@]}")"
  text="${text#' / '}"   # führenden Trenner abschneiden  local text

  if [[ "$target_exists" == true ]]; then
    printf '  - [%s](../../%s)\n' "$text" "$target"
  else
    # Ziel existiert nicht mehr (z.B. gelöscht) → nur Text ohne Link
    printf '  - %s\n' "$text"
  fi
}

# ---- Änderungen pro content/<x>/ gruppieren ---------------------------------
# Liste der betroffenen Top-Level-Ordner (Jahre)
mapfile -t YEARS < <(printf "%s\n" "$CHANGES_RAW" | awk '{print $2}' | cut -d/ -f2 | sort -u)

for YEAR in "${YEARS[@]}"; do
  [[ -z "$YEAR" ]] && continue

  echo ">> Bearbeite content/$YEAR"

  # Änderungen für dieses Jahr extrahieren (nur Pfadspalte)
  ADDED="$(   printf "%s\n" "$CHANGES_RAW" | awk -v y="$YEAR" '$1=="A" && $2 ~ "^content/"y {print $2}' || true)"
  MODIFIED="$(printf "%s\n" "$CHANGES_RAW" | awk -v y="$YEAR" '$1=="M" && $2 ~ "^content/"y {print $2}' || true)"
  DELETED="$( printf "%s\n" "$CHANGES_RAW" | awk -v y="$YEAR" '$1=="D" && $2 ~ "^content/"y {print $2}' || true)"

  # Wenn für dieses Jahr keine Seitenänderungen → überspringen
  if [[ -z "${ADDED}${MODIFIED}${DELETED}" ]]; then
    echo ">> Keine Seitenänderungen für $YEAR – übersprungen."
    continue
  fi

  LATEST_CHANGES_FILE="content/${YEAR}/about/latest-changes/_index.md"

  # Abschnitt bauen
  build_section() {
    echo "## ${TAG_NAME}  "
    echo "_${HUMAN_DATE} auf ${MAIN_REF}_"
    echo

    if [[ -n "${RELEASE_NOTES_TRIMMED}" ]]; then
      echo "### Release Notes"
      while IFS= read -r line; do
        [[ -z "$line" ]] && continue
        echo "- ${line}"
      done <<< "${RELEASE_NOTES_TRIMMED}"
      echo
    fi

    echo "### Seiten-Änderungen"
    if [[ -n "${ADDED}" ]]; then
      echo "- **Hinzugefügt**"
      while IFS= read -r f; do
        [[ -z "$f" ]] && continue
        make_link_line "$f" "$YEAR"
      done <<< "${ADDED}"
    fi
    if [[ -n "${MODIFIED}" ]]; then
      echo "- **Geändert**"
      while IFS= read -r f; do
        [[ -z "$f" ]] && continue
        make_link_line "$f" "$YEAR"
      done <<< "${MODIFIED}"
    fi
    if [[ -n "${DELETED}" ]]; then
      echo "- **Gelöscht**"
      while IFS= read -r f; do
        [[ -z "$f" ]] && continue
        make_link_line "$f" "$YEAR"
      done <<< "${DELETED}"
    fi

    echo
    echo "---"
    echo
  }

  SECTION_CONTENT="$(build_section)"

  # Datei erzeugen oder prependen
  if [[ ! -f "${LATEST_CHANGES_FILE}" ]]; then
    mkdir -p "$(dirname "${LATEST_CHANGES_FILE}")"
    cat > "${LATEST_CHANGES_FILE}" <<EOF
---
title: "Latest Changes"
linkTitle: "Latest Changes"
type: docs
weight: 9999
description: >
  Übersicht der Änderungen für ${YEAR} (Release Notes und Seitenänderungen).
---

${SECTION_CONTENT}
EOF
  else
    TMP_FILE="$(mktemp)"
    if grep -q '^---[ \t]*$' "${LATEST_CHANGES_FILE}"; then
      FRONT_END_LINE="$(awk '/^---[ \t]*$/ {c++; if (c==2) {print NR; exit}}' "${LATEST_CHANGES_FILE}" || true)"
      if [[ -n "${FRONT_END_LINE}" ]]; then
        head -n "${FRONT_END_LINE}" "${LATEST_CHANGES_FILE}" > "${TMP_FILE}"
        echo >> "${TMP_FILE}"
        printf "%s" "${SECTION_CONTENT}" >> "${TMP_FILE}"
        tail -n +$((FRONT_END_LINE+1)) "${LATEST_CHANGES_FILE}" >> "${TMP_FILE}"
      else
        { printf "%s" "${SECTION_CONTENT}"; cat "${LATEST_CHANGES_FILE}"; } > "${TMP_FILE}"
      fi
    else
      { printf "%s" "${SECTION_CONTENT}"; cat "${LATEST_CHANGES_FILE}"; } > "${TMP_FILE}"
    fi
    mv "${TMP_FILE}" "${LATEST_CHANGES_FILE}"
  fi

  echo ">> Latest-Changes aktualisiert: ${LATEST_CHANGES_FILE}"
done

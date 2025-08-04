function loadData(file) {
    const script = document.createElement('script');
    script.src = file;
    script.onload = () => renderTimeline(window.timelineData);
    document.body.appendChild(script);
}

function renderTimeline(data) {
    const container = document.getElementById('timeline');
    container.innerHTML = '';

    const MONTHS_DE = ["Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"];

    function generateMonthLabels(startDate, endDate) {
        if (!startDate || !endDate) return [];
        const [sd, sm, sy] = startDate.split('.').map(Number);
        const [ed, em, ey] = endDate.split('.').map(Number);
        let start = new Date(sy, sm - 1, sd);
        let end = new Date(ey, em - 1, ed);
        let months = [];
        let cur = new Date(start.getFullYear(), start.getMonth(), 1);
        while (cur <= end) {
            months.push(MONTHS_DE[cur.getMonth()]);
            cur.setMonth(cur.getMonth() + 1);
        }
        return months;
    }

    function getISOWeek(dateStr) {
        if (!dateStr) return null;
        const [d, m, y] = dateStr.split('.').map(Number);
        const date = new Date(y, m - 1, d);
        date.setDate(date.getDate() + 4 - (date.getDay() || 7));
        const yearStart = new Date(date.getFullYear(), 0, 1);
        const weekNo = Math.ceil((((date - yearStart) / 86400000) + 1) / 7);
        return weekNo;
    }

    function renderMonthsLabels(startDate, endDate) {
        const months = document.createElement('div');
        months.className = 'month-row';
        
        const titleDiv = document.createElement('div');
        titleDiv.className = 'module-spacer';
        months.appendChild(titleDiv);

        // Container für alle Module
        const container = document.createElement('div');
        container.className = 'module-container';
        months.appendChild(container);

        let monthLabels = generateMonthLabels(startDate, endDate);
        monthLabels.forEach(month => {
            const mDiv = document.createElement('div');
            mDiv.className = 'month';
            mDiv.textContent = month;
            container.appendChild(mDiv);
        });
        return months;
    }

    function formatText(text) {
        if (!text) return '';
        return text.replace(/;/g, '<br>').replace(/\|/g, '<br>');
    }

    function groupItems(items) {
        const grouped = {};
        const noGroup = [];

        items.forEach(item => {
            if (item.group) {
                if (!grouped[item.group]) grouped[item.group] = [];
                grouped[item.group].push(item);
            } else {
                noGroup.push(item);
            }
        });

        return { grouped, noGroup };
    }

    function assignCrossoverRows(items, blockStartKW, allowMixedGroupRows = false) {
        const { grouped, noGroup } = groupItems(items);
        const rows = [];

        // 1. Gruppen zuerst platzieren (jede Gruppe eigene Zeile)
        Object.values(grouped).forEach(groupItems => {
            const rowIndex = rows.length;
            rows[rowIndex] = groupItems.map(m => ({
                ...m,
                startWeek: m.startWeek ?? getISOWeek(m.startDate) - blockStartKW + 1,
                endWeek: m.endWeek ??
                    (m.durationWeeks
                        ? (m.startWeek ?? getISOWeek(m.startDate) - blockStartKW + 1) + m.durationWeeks - 1
                        : getISOWeek(m.endDate) - blockStartKW + 1)
            }));
        });

        // 2. Restliche Items platzieren
        noGroup.forEach(m => {
            const startWeek = m.startWeek ?? getISOWeek(m.startDate) - blockStartKW + 1;
            const endWeek = m.endWeek ??
                (m.durationWeeks
                    ? startWeek + m.durationWeeks - 1
                    : getISOWeek(m.endDate) - blockStartKW + 1);

            let placed = false;

            for (let r = 0; r < rows.length; r++) {
                const rowHasGroup = rows[r].some(item => !!item.group);

                if (allowMixedGroupRows || !rowHasGroup) {
                    const overlaps = rows[r].some(existing =>
                        !(endWeek < existing.startWeek || startWeek > existing.endWeek)
                    );
                    if (!overlaps) {
                        rows[r].push({ ...m, startWeek, endWeek });
                        placed = true;
                        break;
                    }
                }
            }

            if (!placed) {
                rows.push([{ ...m, startWeek, endWeek }]);
            }
        });

        return rows;
    }


    function renderModuleType(moduleDef, blockStartKW, blockEndKW) {
        const row = document.createElement('div');
        row.className = `${moduleDef.type}-row`;

         const titleDiv = document.createElement('div');
         if (moduleDef.title) {
            titleDiv.className = 'module-title';
            titleDiv.innerHTML = formatText(moduleDef.title);
        } else {
            titleDiv.className = 'module-spacer';
        }
        row.appendChild(titleDiv);

        // Container für alle Module
        const container = document.createElement('div');
        container.className = `${moduleDef.type}-container`;
        row.appendChild(container);

        const totalWeeks = blockEndKW - blockStartKW + 1;
        // px Abstand zwischen den Modulen
        const gap = 4; 

        // Berechne Start/Ende
        const processedItems = calculateModuleWeeks(moduleDef, blockStartKW);
        console.log(`Rendering module type: ${moduleDef.type}`, processedItems);

        // Falls Crossover-Layout
        if (moduleDef.alignMode === "crossover") {

            const allowMixed = moduleDef.allowMixedGroupRows ?? false;
            const rowsPacked = assignCrossoverRows(processedItems, blockStartKW, allowMixed);

            rowsPacked.forEach((packedRow) => {
                const subRow = document.createElement('div');
                subRow.className = `${moduleDef.type}-crossover-row`;

                packedRow.forEach(m => {
                    const mod = createModuleElement(m, moduleDef, m.startWeek, m.endWeek, totalWeeks);
                    subRow.appendChild(mod);
                });

                container.appendChild(subRow);
            });

        } else {
            // Normales Layout
            processedItems.forEach(m => {
                const mod = createModuleElement(m, moduleDef, m.startWeek, m.endWeek, totalWeeks);
                container.appendChild(mod);
            });
        }

        return row;
    }

    function calculateModuleWeeks(moduleDef, blockStartKW) {
        let prevEndWeek = 0;

        return moduleDef.items.map(m => {
            if (!m || typeof m !== 'object') return null;

            let startWeek, endWeek;

            if (m.startWeek !== undefined) {
                startWeek = m.startWeek;
            } else if (m.startDate) {
                startWeek = getISOWeek(m.startDate) - blockStartKW + 1;
            } else {
                startWeek = prevEndWeek + 1;
            }

            if (m.endWeek !== undefined) {
                endWeek = m.endWeek;
            } else if (m.endDate) {
                endWeek = getISOWeek(m.endDate) - blockStartKW + 1;
            } else if (m.durationWeeks) {
                endWeek = startWeek + m.durationWeeks - 1;
            } else {
                endWeek = startWeek;
            }

            if( endWeek < startWeek) {
                endWeek += 52;
            }

            prevEndWeek = endWeek;

            return { ...m, startWeek, endWeek };
        }).filter(Boolean);
    }

    function createModuleElement(m, moduleDef, startWeek, endWeek, totalWeeks) {
        const mod = document.createElement('div');       
        mod.className = `${moduleDef.type}`;
        mod.style.backgroundColor = m.color || '#666';

        // px Abstand zwischen den Modulen
        const gap = 4; 

        // Prozentuale Position & Breite
        const percentPerWeek = 100 / totalWeeks;
        mod.style.left = `calc(${(startWeek - 1) * percentPerWeek}% + ${gap / 2}px)`;
        mod.style.width = `calc(${(endWeek - startWeek + 1) * percentPerWeek}% - ${gap}px)`;

        // Inhalte splitten
        const parts = m.name?.split('|').map(s => s.trim()) || [m.name || ''];

        if( parts.length > 1) {
            // Titel
            const title = document.createElement('div');
            title.className = 'title';
            title.innerHTML = formatText(parts[0]);
            mod.appendChild(title);

            // Divider bei 25%
            const divider25 = document.createElement('div');
            divider25.className = 'divider divider-top';
            mod.appendChild(divider25);

            // Inhalt
            const content = document.createElement('div');
            content.className = 'content';
            if (parts.length > 2) {
                content.innerHTML = formatText(parts.slice(1, -1).join('<br>'));
            } else if (parts.length === 2 && !parts[1].startsWith('#')) {
                content.innerHTML = formatText(parts[1]);
            }
            mod.appendChild(content);

            // Divider bei 75%
            const divider75 = document.createElement('div');
            divider75.className = 'divider divider-bottom';
            mod.appendChild(divider75);

            // Code (#J1)
            const last = parts[parts.length - 1];
            if (last?.startsWith('#')) {
                const codeDiv = document.createElement('div');
                codeDiv.className = 'code';
                codeDiv.textContent = last;
                mod.appendChild(codeDiv);
            }
        } else {
            const content = document.createElement('div');
            content.className = 'content';
            content.innerHTML = formatText(m.name);
            mod.appendChild(content);
        }
        return mod;
    }

    data.forEach(block => {
        const blockDiv = document.createElement('div');
        blockDiv.className = 'timeline-block';

        const title = document.createElement('div');
        title.className = 'block-title';
        title.textContent = block.title;
        blockDiv.appendChild(title);

        const blockStartKW = block.startDate ? getISOWeek(block.startDate) : block.startWeek? block.startWeek: 1;
        let blockEndKW = block.endDate ? getISOWeek(block.endDate) : block.endWeek? block.endWeek: 1;
        blockEndKW = (blockEndKW > blockStartKW ? blockEndKW : blockEndKW + 52);

        console.log(`Rendering block: ${block.title} from week ${blockStartKW} to week ${blockEndKW}`, block);

        block.modules.forEach(moduleDef => {
            blockDiv.appendChild(renderModuleType(moduleDef, blockStartKW, blockEndKW));
        });

        blockDiv.appendChild(renderMonthsLabels(block.startDate, block.endDate));

        container.appendChild(blockDiv);
    });
}

function getQueryParam(name) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(name);
}

function isSafeDataset(name) {
    if (!name) return false;
    if (name.includes('/') || name.includes('\\')) return false; // kein Pfad erlaubt
    if (!name.endsWith('.js')) return false; // muss .js enden
    if (name.toLowerCase() === 'script.js') return false; // nicht dein Hauptscript
    return true;
}

let datasetParam = getQueryParam('dataset');
let datasetFile;

// nur prüfen, wenn Parameter vorhanden
if (datasetParam && isSafeDataset(datasetParam)) {
    datasetFile = datasetParam;
} else if (datasetParam) {
    console.warn(`Ungültiger dataset-Parameter: "${datasetParam}". Verwende Standarddatei.`);
    datasetFile = 'data-2025-2026.js';
} else {
    // kein Parameter → Standarddatei
    datasetFile = 'data-2025-2026.js';
}

loadData(datasetFile);
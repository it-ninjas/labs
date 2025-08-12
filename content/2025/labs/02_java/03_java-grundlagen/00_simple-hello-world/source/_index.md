---
title: "simple-hello-world - Source"
linkTitle: "Source"
type: docs
weight: 0
description: >
  Source code for simple-hello-world
build:
  list: never
  render: always
cascade:
  _menu: false
---

## Verzeichnis-Struktur

```console
simple-hello-world
├── .ideaOff
│   ├── codeInsightSettings.xml
│   ├── editor.codeinsight.xml
│   ├── misc.xml
│   └── plugins.xml
├── src
│   └── Main.java
├── .gitignore
└── README.md
```

## Dateien in simple-hello-world

##### .gitignore{#gitignore}

```
*.iml
.idea/
out/
target/
build/
```

##### README.md{#readme-md}

Not able to display content!

### .ideaOff

##### codeInsightSettings.xml{#ideaoff-codeinsightsettings-xml}

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project version="4">
  <component name="CodeInsightSettings">
    <option name="AUTO_POPUP_COMPLETION_LOOKUP" value="false" />
    <option name="AUTO_POPUP_JAVADOC_INFO" value="false" />
    <option name="SHOW_PARAMETER_NAME_HINTS" value="false" />
    <option name="SHOW_FULL_SIGNATURES_IN_PARAMETER_INFO" value="false" />
    <option name="SMART_TYPE_COMPLETION" value="false" />
    <option name="AUTO_POPUP_PARAMETER_INFO" value="false" />
  </component>
</project>

```

##### editor.codeinsight.xml{#ideaoff-editor-codeinsight-xml}

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project version="4">
  <component name="EditorCodeInsightSettings">
    <option name="SHOW_QUICK_DOC_ON_MOUSE_OVER" value="false" />
    <option name="SHOW_QUICK_DOC_ON_COMPLETION" value="false" />
    <option name="AUTO_POPUP_COMPLETION_LOOKUP" value="false" />
    <option name="WORD_COMPLETION" value="false" />
  </component>
</project>

```

##### misc.xml{#ideaoff-misc-xml}

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project version="4">
  <component name="AISettings">
    <option name="enableAIFeatures" value="false" />
  </component>
</project>

```

##### plugins.xml{#ideaoff-plugins-xml}

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project version="4">
  <component name="PluginManager">
    <disabled-plugins>
      <plugin id="com.intellij.ai" />
      <plugin id="com.github.copilot" />
    </disabled-plugins>
  </component>
</project>

```

### src

##### Main.java{#src-main-java}

```java
/**
 * Schau Dir das Programm an und versuche es zum Laufen zu bringen. Versuche, ein paar kleine Änderungen am Programm
 * vorzunehmen.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, world!");
    }
}

```

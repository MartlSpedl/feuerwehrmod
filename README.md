# Feuerwehr Mod (Fabric, Minecraft 1.20.1)

## Voraussetzungen

- **JDK 17** installiert (Fabric 1.20.1 benötigt genau Java 17)
- IntelliJ IDEA (empfohlen) oder Eclipse
- Internetzugang beim ersten Build (lädt Minecraft, Mappings, Fabric API)

## Setup

1. **Wichtig:** Dieses Projekt braucht **Loom 1.6.12** (fest gepinnt, keine
   `-SNAPSHOT`-Version!) zusammen mit **Gradle 8.8** und **Java 17**.
   `-SNAPSHOT`-Versionen von Loom zeigen immer auf den neuesten Nightly-Build,
   der sich jederzeit ändern und mit deiner installierten Gradle-Version
   inkompatibel werden kann (genau das hat den Fehler
   `Could not create an instance of type ... LoomProblemReporter` verursacht).
2. Einmalig den Gradle-Wrapper mit der passenden Version erzeugen
   (Voraussetzung: irgendeine Gradle-Version lokal installiert, z.B. über
   [sdkman](https://sdkman.io/) oder den Paketmanager deines Systems):
   ```
   gradle wrapper --gradle-version 8.8
   ```
   Das erstellt `gradlew`, `gradlew.bat` und `gradle/wrapper/gradle-wrapper.jar`.
   Ab jetzt immer `./gradlew` statt `gradle` verwenden, damit garantiert die
   richtige Gradle-Version genutzt wird.
3. Projektordner in IntelliJ IDEA öffnen ("Open" → Ordner auswählen).
   IntelliJ erkennt automatisch das Gradle-Projekt und importiert es.
4. Ersten Build/Sync starten:
   ```
   ./gradlew build
   ```
   Das lädt Minecraft 1.20.1, die Yarn-Mappings und die Fabric API herunter
   und dekompiliert Minecraft für die Entwicklung. Das kann beim ersten Mal
   einige Minuten dauern.
5. Zum Testen im Spiel:
   ```
   ./gradlew runClient
   ```
   Startet eine Minecraft-Instanz mit installierter Mod.

## Troubleshooting

**Fehler: `Could not create an instance of type ... LoomProblemReporter` /
`Problems.forNamespace`**
→ Das bedeutet, deine Gradle-Version passt nicht zur Loom-Version. Prüfe:
- `build.gradle`: `id 'fabric-loom' version '1.6.12'` (keine `-SNAPSHOT`-Version)
- Gradle-Wrapper zeigt auf Gradle 8.8 (siehe `gradle/wrapper/gradle-wrapper.properties`)
- Falls der Fehler weiter auftritt: `./gradlew --version` ausführen und prüfen,
  ob wirklich 8.8 verwendet wird, nicht eine global installierte, andere Version.

## Aktueller Stand

- Grundgerüst (Mod-Initialisierung, Client-Initialisierung)
- Erstes Test-Item: `feuerwehr_ausweis` (nur zur Verifikation, dass die
  Registrierung funktioniert – wird später durch echte Ausrüstung ersetzt)

## Geplante nächste Schritte

1. Feuerwehrhaus als Structure-Template bauen und Weltgenerierung anbinden
2. Spieler-Datenspeicherung (Ausbildungsstatus, Rang) via Fabric-Komponenten
   oder eigenes `PersistentState`
3. Ausbildungssystem (Quest-Stufen)
4. Einsatzsystem inkl. Benachrichtigungen

## Projektstruktur

```
src/main/java/com/feuerwehrmod/
├── FeuerwehrMod.java      # Haupt-Entrypoint
├── block/                 # Eigene Blöcke (Alarmanlage, Spind, ...)
├── item/                  # Items (Ausrüstung, Ausweis, ...)
├── structure/             # Feuerwehrhaus-Weltgenerierung
├── training/              # Ausbildungssystem
├── mission/               # Einsatzsystem
├── network/                # Client-Server-Packets
├── data/                   # Spieler-/Weltdaten (Persistenz)
└── util/                   # Hilfsklassen

src/client/java/com/feuerwehrmod/client/
└── FeuerwehrModClient.java # Client-Entrypoint (HUD, Sounds, etc.)
```

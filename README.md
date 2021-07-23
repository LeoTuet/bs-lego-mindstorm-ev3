# LegoRoboEV3
IntelliJ Projekt Vorlage für die Aufgabe ’Abräumen’ mit dem Lego Roboter (für windows) in der städtischen Berufsschule für Informationstechnik
- - -

## Requirements
- Java 7
- Putty

## Setup
- Projekt clonen und IntelliJ das Maven projekt laden lassen
- in ip.txt die IP-Adresse des Bots eingeben
- Code ist unter src/main/java/robot/Main.java

## Deploy

### Batchfiles
1. Build > Build Artifacts > LegoRoboter.jar > Build
2. Bei Passwortanfragen Enter eingeben
3. warten

### Bash Script
1. Run > Edit Configurations... > New Configuration > Shell Script
2. Bei Script Path den Pfad zur start.sh angeben
3. Before Launch > Add > Run Maven Goal
4. package bei Command Line eingeben
5. Runnen und warten


## Die Regeln von Leo
1. Niemand pushed auf main! (Außer Marc)

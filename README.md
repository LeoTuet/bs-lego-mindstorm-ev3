# LegoRoboEV3
IntelliJ Projekt Vorlage für die Aufgabe ’Abräumen’ mit dem Lego Roboter (für windows) in der städtischen Berufsschule für Informationstechnik
- - -

## Requirements
- Java 7

## Setup
- Projekt clonen und IntelliJ das Maven projekt laden lassen
- in ip.txt die IP-Adresse des Bots eingeben
- Code ist unter src/main/java/robot/Main.java

## Deploy

### Batchfiles
1. Build > Build Artifacts > LegoRoboter.jar > Build
2. Bei Passwortanfragen Enter eingeben
3. warten

### Bash Script (Build & Deploy)
1. Run > Edit Configurations... > New Configuration > Shell Script
2. Bei Script Path den Pfad zur start.sh angeben
3. Before Launch > Add > Run Maven Goal
4. package bei Command Line eingeben
5. Runnen und warten


###Screenshot Tutorial for (Build & Deploy)
1.

<img height="50%" width="50%" alt="Step1" src="https://raw.githubusercontent.com/LeoTuet/LegoRoboEV3/main/assets/images/1.png">

2.

<img height="50%" width="50%" alt="Step2" src="https://raw.githubusercontent.com/LeoTuet/LegoRoboEV3/main/assets/images/2.png">

3.

<img height="50%" width="50%" alt="Step3" src="https://raw.githubusercontent.com/LeoTuet/LegoRoboEV3/main/assets/images/3.png">

4.

<img height="50%" width="50%" alt="Step4" src="https://raw.githubusercontent.com/LeoTuet/LegoRoboEV3/main/assets/images/4.png">

5.

<img height="50%" width="50%" alt="Step5" src="https://raw.githubusercontent.com/LeoTuet/LegoRoboEV3/main/assets/images/5.png">

## Die Regeln von Leo
1. Niemand pushed auf main! (Außer Marc und Niklas)

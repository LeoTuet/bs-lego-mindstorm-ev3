# LegoRoboEV3
IntelliJ Projekt Vorlage für die Aufgabe ’Abräumen’ mit dem LEGO MINDSTORMS® EV3 in der Städtischen Berufsschule für Informationstechnik
- - -

## Requirements
- Java 7
- Git

## Setup
- Projekt clonen und IntelliJ das Maven Projekt laden lassen
- in ip.txt die IP-Adresse des Bricks eingeben
- Code ist unter src/main/java/robot/Main.java
- API für Sensoren unter src/main/java/robot/api

## Deploy

### Bash Script (Build & Deploy)
1. Run > Edit Configurations... > New Configuration > Shell Script
2. Bei Script Path den Pfad zur start.sh angeben
3. Before Launch > Add > Run Maven Goal
4. package bei Command Line eingeben
5. Runnen
6. Bei Passwort abfrage "Enter" drücken
7. Warten


### Screenshot Tutorial für (Build & Deploy)
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
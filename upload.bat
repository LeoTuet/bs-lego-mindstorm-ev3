@echo off
set IP=10.96.210.60
title Upload LegoRobo
echo Uploading...
pscp -P 22 -scp out/LegoRoboter.jar root@%IP%:/home/lejos/programs
pause

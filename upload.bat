@echo off
set /p IP=<ip.txt
title Upload LegoRobo
echo Uploading...
scp -oKexAlgorithms=+diffie-hellman-group1-sha1 -c 3des-cbc out/LegoRoboter.jar root@%IP%:/home/lejos/programs
pause

@echo off
ssh -oKexAlgorithms=+diffie-hellman-group1-sha1 -c 3des-cbc root@10.96.210.44 "jrun -jar /home/lejos/programs/LegoRoboter.jar"
pause
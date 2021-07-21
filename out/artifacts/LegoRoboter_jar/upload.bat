@echo off
pscp -P 22 -scp out/artifacts/LegoRoboter_jar/LegoRoboter.jar root@10.96.210.44:/home/lejos/programs
pause
#!/bin/bash

set echo off
read IP=10.96.210.56
title "Run LegoRobo"
echo "Running..."
ssh -oKexAlgorithms=+diffie-hellman-group1-sha1 -c 3des-cbc root@%IP% "jrun -jar /home/lejos/programs/LegoRoboter.jar"
pause

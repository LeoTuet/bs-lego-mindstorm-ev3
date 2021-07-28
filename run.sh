#!/bin/bash

set echo off
echo "Running..."
ssh -oKexAlgorithms=+diffie-hellman-group1-sha1 -c 3des-cbc root@10.96.210.42 "jrun -jar /home/lejos/programs/LegoRoboter.jar"


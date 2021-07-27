#!/bin/bash

set echo off
echo "Uploading..."
pscp -P 22 -scp out/LegoRoboter.jar root@10.96.210.44:/home/lejos/programs

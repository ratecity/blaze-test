#!/bin/sh
node app.js&
while [ 1 ]
do
	#Xvfb :10 -screen 0 1366x768x24 -ac&
	#DISPLAY=:10 xvfb-run java -jar ~/selenium/selenium-server-standalone-2.44.0.jar&
	mkdir -p runs/`date '+%m'`/`date '+%d'`/`date '+%H'`
	npm run test > runs/`date '+%m'`/`date '+%d'`/`date '+%H'`/`date '+%m_%d_%H:%M:%S'`.output
	#killall chrome
	#killall chromedriver
	#killall xvfb-run
	#killall Xvfb
	#killall java
done

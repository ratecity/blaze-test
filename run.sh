#!/bin/sh
while [ 1 ]
do
	mkdir -p runs/`date '+%m'`/`date '+%d'`/`date '+%H'`
	npm run test > runs/`date '+%m'`/`date '+%d'`/`date '+%H'`/`date '+%m_%d_%H:%M:%S'`.output
done

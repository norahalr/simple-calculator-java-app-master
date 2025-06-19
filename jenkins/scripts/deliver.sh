#!/usr/bin/env bash

echo 'The following Maven command installs your Maven-built Java application'
echo 'into the local Maven repository, which will ultimately be stored in'
echo 'Jenkins''s local Maven repository (and the "maven-repository" Docker data'
echo 'volume).'
set -x
mvn jar:jar install:install help:evaluate -Dexpression=project.name
set +x

echo 'The following command runs and outputs the execution of your Java'
echo 'application (which Jenkins built using Maven) to the Jenkins UI.'
set -x
FINAL_NAME=`mvn help:evaluate -Dexpression=project.build.finalName | grep "^[^\[]"`
echo 'current working directory: ' $PWD
echo 'Application: ' ${FINAL_NAME}
mvn exec:java -Dexec.mainClass="nl.ordina.Calculate"

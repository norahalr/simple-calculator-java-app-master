# Introduction
The following repository has only been created for demo purposes. It will just contain a basic calculator application 
written in Java and will be used in conjunction with project [Build a Java app with Maven](https://jenkins.io/doc/tutorials/build-a-java-app-with-maven/) 
tutorial from the [Jenkins User Documentation](https://jenkins.io/doc/).

# Project Goal
The main goal is to demonstrate how to spin up a `Jenkins` service to build, test our code and eventually run/deploy it. 
All these steps will be executed in the form of a pipeline defined in a Jenkins file. Jenkins provides different plugins
to view a pipeline, but we will make use of `Blue Ocean` as it has many improvements compared to other plugins.

# Quality Assurance (QA)
An addition to this project the `Sonarqube` service has been included. We will use this tool to scan our codebase so that
it can provide us with a wide arrange of `Code Quality Metrics` to improve our codebase.

# CI/CD Stack
The complete stack will run on docker containers for Jenkins/Sonarqube and PostgreSQL. A docker compose file has been 
included to launch all these services.

# Resources
Other useful resources for this project
* https://github.com/fischer1983/docker-compose-jenkins-sonarqube
* https://www.baeldung.com/sonar-qube
* https://funnelgarden.com/sonarqube-jenkins-docker/
* https://blog.sandra-parsick.de/2020/06/10/test-coverage-reports-for-maven-projects-in-sonarqube-8-3-x/

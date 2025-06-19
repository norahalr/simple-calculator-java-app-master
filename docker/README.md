# Docker Commands
Some useful docker commands that can be used to kickstart a set of services or to check if everything is running as
planned
```shell script
$ docker-compose ps -a
$ docker-compose up -d
$ docker-compose down

$ docker ps -a
$ docker image ls
$ docker volume ls
$ docker volume purge

$ docker exec -it [container] bash
```

# Install Maven on Jenkins docker image

We need to provide the Jenkins container with an installation of Maven so that it can build Java applications. To
achieve
this two options are available. Option 1 makes use of a DockerFile to build a new layer on top of the base image and
install Maven. Option 2 requires a running Jenkins container in which you access the terminal and
execute a set of commands to install Maven.

<b>Option 1: Build image via DockerFile</b>

```shell script
$ cd docker
$ docker build -t accelerator/jenkins-lts-maven . #use this new image in docker-compose.yml
```

<b>Option 2: Access Jenkins container terminal to and install Maven</b>

```shell script
$ docker exec -u root -it [container] bash #[container=jenkins]
$ apt-get update & apt-get install
$ apt-get install maven -y
```

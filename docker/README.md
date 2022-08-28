# Helpful Commands:

### Verify installation and set-up

To check if docker is installed in your computer, try to check for its version: `docker --version`

Cannot connect to the Docker daemon at unix:///var/run/docker.sock. Is the docker daemon running?
`systemctl start docker`

To check if Docker Client is talking to Docker Daemon and that Docker Daemon is talking to Docker Hub successfully: `docker run hello-world`

`sudo systemctl status docker`

To check if docker is running : 

```
sudo service docker status
```

If you see errors like the ones below:

```
[explorer436@explorer436-Thinkpad ~]$ docker ps
Got permission denied while trying to connect to the Docker daemon socket at unix:///var/run/docker.sock: Get "http://%2Fvar%2Frun%2Fdocker.sock/v1.24/containers/json": dial unix /var/run/docker.sock: connect: permission denied

[explorer436@explorer436-Thinkpad ~]$ docker run hello-world
docker: Got permission denied while trying to connect to the Docker daemon socket at unix:///var/run/docker.sock: Post "http://%2Fvar%2Frun%2Fdocker.sock/v1.24/containers/create": dial unix /var/run/docker.sock: connect: permission denied.
```

change the permissions of the files
```
$ sudo chmod 666 /var/run/docker.sock 
```

See 'docker run --help'.

### Images

A Docker image is DockerHub is a static template - a set of bytes.

Image is like a class and container is like an object based on that class.

To search for images in docker hub, either use the web interface or use this command: `sudo docker search mongodb`

To pull an image from a registry (DockerHub) into our machine: `docker pull mysql` or `docker pull myimage:1.0`

To Retag a local image with a new image name and tag: `docker tag myimage:1.0 myrepo/myimage:2.0`

To push an image to a registry: `docker push myrepo/myimage:2.0`

To view the history of a Docker image: `docker image history imageId`
To inspect the history of a Docker image: `docker image inspect imageId`
To remove a Docker image from local machine: `docker image remove imageId`

##### Build

Build an image from the Dockerfile in the current directory and tag the image: `docker build -t myimage:1.0`

List all images that are locally stored with the Docker Engine: `docker image ls`
To list all the images that are pulled into the machine from DockerHub: `docker images`

Delete an image from the local image store: `docker image rm alpine:3.4`

### Containers

`Docker Container` - a running version of the image. For the same image, we can have multiple containers running.

#### Running containers

Run a container from the Alpine version 3.9 image, name the running container "web" and expose port 5000 externally, mapped to port 0 inside the container: `docker container run --name web -p 5000:80 alpine:3.9`

```
docker run -p 5000:5000 nameOfTheDockerRepository/nameOfTheApplication
docker run -p {HostPort}:{ContainerPort} nameOfTheDockerRepository/nameOfTheApplication
```
 
(docker run is a shortcut for docker container run)

To list the running containers: `docker container ls`
To list the running and terminated containers: `docker container ls -a`

#### Detatched mode

If we want the container to be running in the background, use the `-d` option.This way, the terminal is not tied to the lifecycle of the container. Detatched mode:`docker run -p 5000:5000 -d nameOfTheDockerRepository/nameOfTheApplication`

#### Stopping containers

To stop a container based on containerId : `docker container stop containerId`

This will give the application that is running in the container some time to gracefully shut itself down. e.g. close connection pools, close executorService, etc.
stop -> SIGTERM -> graceful shutdown

#### Killing containers

To kil a container based on containerId : `docker container kill containerId`

- Kill the container and the application that is running in it right away.
- kill -> SIGKILL  -> immediately terminate the process

#### Pausing containers

- To pause a container: `docker container pause containerId`
- To unpause a container: `docker container unpause containerId`

#### Inspect containers

To inspect a container: `docker container inspect containerId`

### docker system commands

docker system df         # Show docker disk usage, including space reclaimable by pruning

#### Removing containers

```
docker container prune                     # Remove all stopped containers
docker volume prune                        # Remove all unused volumes
docker image prune                         # Remove unused images
docker system prune                        # All of the above, in this order: containers, volumes, images
docker container rm -f $(docker ps -aq)    # Delete all running and stopped containers
```

When there is "not enough space" error from Docker, use this command to clean up the stopped and running containers: `docker system prune -a`

#### Processes in a container

To display the processes running in a container: `docker top containerId`

#### Live stream

To display a live stream of container(s) resource usage statistics: `docker stats`

### Bridge network

Every container that runs is a part of the bridge network in Docker - it is an internal Docker network. Nobody will be able to access it unless we specifically expose it on to the host system where the container is running.

List the networks
```
docker network
docker network ls

```

### Logs

To look at logs for a container that is running: `docker logs containerId` (you don't have to type the entire id. A subset of the id will do)

To follow the logs: `docker logs -f containerId`

Print the last 100 lines of a container's logs: `docker container logs --tail 100 web`

### Events

To view the events happening in docker: `docker events`

### Other references:

Take a look at the docker-compose files in the following repository for details about setting up multiple containers in the same network:

proof-of-concepts/spring-data-mongodb-rest/

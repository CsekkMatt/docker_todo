# TODO application in a container 

## Commands 


### create mynetwork in docker 
    docker network create mynetwork

### create mongodb instance in mynetwork

    docker run -d --network=todo_mynetwork --name mongodb -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=password mongo


### To create a build
    mvn clean install 
 
### To stop running container (if running)
    docker stop springbootapp

    docker rm springbootapp

### Build docker image from Dockerfile 

    docker build -t myapp .

### Run spring app container 

	docker run -d --network=todo_mynetwork --name springbootapp -p 8080:8080 myapp





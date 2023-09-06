# dear-comrade-topic

## Run test case
### ./gradlew test

## Run application
### ./gradlew bootRun

## Build Docker Image
### ./gradlew bootBuildImage

## Build Application
### ./gradlew build (test+bootJar)

## Creating Jar
### ./gradlew bootJar

## Run tests
### ./gradlew test --tests TrackTypeValidationTest

## Create docker network
### docker network create catalog-network

## Change docker image tag and name
### docker tag dear-comrade-topic:latest ghcr.io/shiva508/dear-comrade-topic:0.0.3

## Push Docker image
### docker push ghcr.io/shiva508/dear-comrade-topic:0.0.3

## Build Image
### ./gradlew bootBuildImage

## Build and push image
### ./gradlew bootBuildImage --imageName ghcr.io/shiva508/dear-comrade-topic --publishImage -PregistryUrl=ghcr.io -PregistryUsername=shiva508 PregistryToken=<your_github_token>
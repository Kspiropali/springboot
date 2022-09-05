FROM openjdk:17-jdk-slim-buster
#Working directory of emulated environment in DOCKER IMAGE
WORKDIR /app

#Copying app.jar in $WORKDIR/build/
COPY springboot/app/build/libs/main.jar build/

#Entering $WORKDIR/build
WORKDIR /app/build

#Executing jar server file
ENTRYPOINT java -jar main.jar

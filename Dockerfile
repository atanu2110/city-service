# For Java 17, try this
FROM openjdk:17-jdk-slim-buster

# Refer to Maven build -> finalName
ARG JAR_FILE=target/city-service-0.0.1-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/city-service-0.0.1-SNAPSHOT.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar
 
# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
FROM openjdk:8-jdk-alpine
EXPOSE 8890
ADD /target/JSONParser-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]

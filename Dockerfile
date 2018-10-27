FROM openjdk:8-jdk-alpine
EXPOSE 8888
ADD /target/UploadAPI-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]

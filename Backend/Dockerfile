# means to build our image upon java:8 image from Docker Hub.
FROM openjdk:17-jdk-alpine
COPY target/Employee-Management-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar" ]



Docker file:
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/openshift-java-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

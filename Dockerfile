#FROM openjdk:8-jdk-alpine
#WORKDIR /app
#COPY ./gradle/ ./gradle

#RUN gradlew build
#COPY src ./src
#CMD ["./gradlew", "spring-boot:run"]
#VOLUME /tmp
#ADD build/libs/openshift-java-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]


FROM gradle:7.1.1-jdk8 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon 

FROM openjdk:8-jre-slim

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/openshift-java-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/openshift-java-0.0.1-SNAPSHOT.jar"]

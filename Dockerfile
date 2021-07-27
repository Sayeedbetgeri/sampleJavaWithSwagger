FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY .gradle/ .gradle

RUN ./gradlew build
COPY src ./src
CMD ["./gradlew", "spring-boot:run"]
#VOLUME /tmp
#ADD build/libs/openshift-java-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

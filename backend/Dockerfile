FROM openjdk:11-jdk-slim as builder
COPY . /project
WORKDIR /project
RUN ./gradlew backend:bootJar
WORKDIR backend/build/libs

FROM openjdk:11-jdk-slim
VOLUME /tmp
COPY --from=builder /project/backend/build/libs/backend-0.0.1-SNAPSHOT.jar backend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/backend-0.0.1-SNAPSHOT.jar"]

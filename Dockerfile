FROM maven:3.8.5-openjdk-17 AS maven_build
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

FROM eclipse-temurin:17-jdk-alpine
MAINTAINER schoflo
EXPOSE 8080

COPY --from=0 "/tmp/" kubernetes-spring-0.0.1.jar
RUN ls -la ./
ENTRYPOINT ./kubernetes-spring
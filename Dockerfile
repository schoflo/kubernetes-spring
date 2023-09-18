FROM maven:3.9.4-eclipse-temurin-17-alpine AS maven_build
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package


FROM eclipse-temurin:17-jdk-alpine
MAINTAINER schoflo
EXPOSE 8080

COPY --from=0 "/tmp/target/app.jar" app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

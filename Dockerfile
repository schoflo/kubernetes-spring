FROM maven:3.11.0-openjdk-17 AS maven_build
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package


FROM eclipse-temurin:17-jdk-alpine
MAINTAINER schoflo
EXPOSE 8080

CMD java -jar /data/kubernetes-spring-0.0.1.jar
COPY --from=maven_build /tmp/target/kubernetes-spring-0.0.1.jar /data/kubernetes-spring-0.0.1.jar
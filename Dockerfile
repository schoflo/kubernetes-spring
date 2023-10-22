FROM maven:3.9.4-eclipse-temurin-17 AS maven_build
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package


FROM eclipse-temurin:17-jdk-alpine
LABEL author=schoflo
EXPOSE 8080

COPY --from=0 "/tmp/target/kubernetes-spring.jar" kubernetes-spring.jar
ENTRYPOINT ["java","-jar","/kubernetes-spring.jar"]


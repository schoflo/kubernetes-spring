FROM maven:3.9.9-eclipse-temurin-21 AS maven_build
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn clean package -DskipTests


FROM eclipse-temurin:21-jdk-alpine
LABEL author=schoflo
EXPOSE 8080

COPY --from=0 "/tmp/target/kubernetes-spring.jar" kubernetes-spring.jar
ENTRYPOINT ["java","-jar","/kubernetes-spring.jar"]


FROM eclipse-temurin:17-jdk-alpine
MAINTAINER schoflo
EXPOSE 8080
RUN mvn package
COPY --from=maven_build /tmp/target/kubernetes-spring-0.0.1.jar /data/kubernetes-spring-0.0.1.jar
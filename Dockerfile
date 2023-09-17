FROM eclipse-temurin:17-jdk-alpine
COPY target/kubernetes-spring-0.0.1-SNAPSHOT.jar kubernetes-spring-0.0.1.jar
LABEL org.opencontainers.image.source=https://github.com/schoflo/kubernetes-spring
ENTRYPOINT ["java","-jar","/kubernetes-spring-0.0.1.jar"]
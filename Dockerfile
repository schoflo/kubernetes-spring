FROM eclipse-temurin:17-jdk-alpine
WORKDIR /opt
ENV PORT 8080
EXPOSE 8080
COPY target/*.jar /opt/kubernetes-spring.jar
ENTRYPOINT exec java "$JAVA_OPTS" -jar kubernetes-spring.jar



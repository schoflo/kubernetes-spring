FROM eclipse-temurin:17-jdk-alpine
ENV PORT 8080
EXPOSE 8080
COPY target/kubernetes-spring.jar kubernetes-spring.jar
ENTRYPOINT ["java","-jar","/kubernetes-spring.jar"]



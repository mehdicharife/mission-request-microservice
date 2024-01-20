FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} mission-request-service.jar
ENTRYPOINT ["java", "-jar", "/mission-request-service.jar"]
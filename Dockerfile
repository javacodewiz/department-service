FROM amazoncorretto:21-alpine
LABEL description="Spring Boot Department Service"
LABEL authors="javacodewiz"
WORKDIR /app
COPY target/*.jar department-service.jar
ENTRYPOINT ["java", "-jar","department-service.jar"]
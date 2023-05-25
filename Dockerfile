FROM eclipse-temurin:17-jdk-alpine
COPY build/libs/drones-0.0.1-SNAPSHOT.jar drones.jar
EXPOSE 8080
CMD ["java", "-jar", "drones.jar"]
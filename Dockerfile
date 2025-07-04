# Stage 1: Build the app with Maven
FROM maven:3.9.4-eclipse-temurin-21 AS build

WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the app (skip tests to speed up)
RUN mvn clean package -DskipTests

# Stage 2: Run the app with Java 21 JRE
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port your Spring Boot app listens on (default 8080)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]

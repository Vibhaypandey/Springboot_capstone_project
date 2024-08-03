# Use a base image with JDK and Maven pre-installed
FROM maven:3.8.1-openjdk-11-slim AS build
WORKDIR /app

# Copy Maven dependency definitions
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Create the final image
FROM openjdk:11-jre-slim
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/my-spring-boot-app.jar ./app.jar

# Command to run the application
CMD ["java", "-jar", "app.jar"]

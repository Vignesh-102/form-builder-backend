# Step 1: Use Maven to build the app
FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Step 2: Use a lightweight base image to run the app
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/formbuilder-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

# Step 1: Use a base image with Java
FROM openjdk:17-jdk-slim

# Step 2: Set a working directory
WORKDIR /app

# Step 3: Copy the jar file to the container
COPY target/formbuilder-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

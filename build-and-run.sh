#!/bin/bash

echo "🧹 Cleaning and packaging Spring Boot app..."
mvn clean package -DskipTests

echo "🐳 Starting Docker Compose..."
docker-compose up --build

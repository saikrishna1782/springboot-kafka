#!/bin/bash

echo "Building Spring Boot Docker image..."
docker-compose build springboot-app

echo "Starting Zookeeper container..."
docker-compose up -d zookeeper

echo "Waiting for Zookeeper to be ready..."

# Wait until Zookeeper port 2181 is open
while ! nc -z localhost 2181; do
  echo "Waiting for Zookeeper..."
  sleep 3
done

echo "Zookeeper is ready!"

echo "Starting Kafka and other containers..."
docker-compose up -d kafka akhq springboot-app

echo "Waiting for Kafka to initialize..."
sleep 20  # Optional: wait a bit for Kafka to fully start

echo "All services are up! Access Spring Boot at http://localhost:8080"

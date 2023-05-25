# Deploying And Running Drone Application

This repository contains a drone application along with a Docker Compose configuration for easy deployment.

## Prerequisites

- Docker: Ensure that Docker is installed on your machine. You can download Docker from the official website: [https://www.docker.com/get-started](https://www.docker.com/get-started)

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/kiranpariyar1502/drones.git

2. Navigate to the project directory:

    ```bash
    cd drones

3. Build the project
   
     ```bash
     ./gradlew build
   
4. Build the Docker image:

    ```bash
    docker-compose build

5. Start the Docker containers:

   ```bash
   docker-compose up -d
   
   The -d flag runs the containers in detached mode, allowing them to run in the background.

6. Access the application:

   Once the containers are up and running, you can access the Drone application in your browser at http://localhost:8080.

   ```
   a. Fetch availale drone
      curl http://localhost:8080/drones/available
   
   
   b. Register a drone 
   curl --location 'http://localhost:8080/drones/register' --header 'Content-Type: application/json' \
   --data '{
   "serialNumber":"AVAILABLE",
   "model":"LightWeight",
   "weightLimit":500.0,
   "batteryLevel":50,
   "state":"IDLE"
   }'
   
   
   c.  Load a drone with medication
    curl --location 'http://localhost:8080/drones/1/load' \
   --header 'Content-Type: application/json' \
   --data '{
   "name":"Medicine1",
   "weight":300,
   "code":"1789ABCD",
   "image":"base64encodeimage"
   }'
   
   
   d. Get loaded medication for particular drone
   curl 'http://localhost:8080/drones/4/medications'
   

   e. Get drone information
   curl 'http://localhost:8080/drones/100'


7. Stopping Drone Application
   
   ```bash
   docker-compose down
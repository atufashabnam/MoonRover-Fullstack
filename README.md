# Moon Rover Application

## Introduction
The Moon Rover Application is a simulation of a moon rover moving on a tabletop. It
allows users to control a rover by placing it on the tabletop, moving it in different directions,
and retrieving its position. This document provides an overview of the application and
instructions for deploying and using it.

## Assumptions:
1. The tabletop size is 5 * 5
2. Table size will always be positive, that is, it will be in top right quadrant of a
circle.

## Features:
The Moon Rover Application provides the following features:
1. Placing the rover on the tabletop at specific coordinates and direction.
2. Moving the rover one unit in the given direction.
3. Turning the rover left or right, changing its direction accordingly.
4. Retrieving the current position of the rover on the tabletop.
   
## System Requirements
To run the Moon Rover Application, ensure that the following system requirements
are met:
1. Java Development Kit (JDK) 17 or higher installed.
2. Maven build tool installed.
3. Access to the internet to download dependencies.
4. Sufficient system resources (CPU, memory) based on expected usage.
5. If deploying using Docker, then docker should be installed
   
## Deployment Steps:

### Running maven commands
1. Download the application from the release location.
2. Extract the package
3. Open the terminal in your server.
4. cd to the extracted package and then cd moonrover.
5. run mvn clean install
6. Run the following command to start the application:
    mvn spring-boot:run
7. Wait for the application to start. Once started, you will see log messages
indicating successful initialization.
8. The application is now running and accessible through the following URL:
`http://localhost:8080`


## API Documentation
The Moon Rover Application exposes a REST API to interact with the rover. Below are the
available API endpoints:
1. Place Rover: Places the rover on the tabletop at specific coordinates and direction.
  - Method: POST
  - Endpoint: http://localhost:8080/api/v1/rover/place
  - Request Body:
  - {
      xAxis: 4,
      yAxis: 3,
      direction: west
    }

2. Move Rover: Moves the rover one unit in the given direction.
- Method: Post
- Endpoint: http://localhost:8080/api/v1/rover/move
- Request Body: {}

3. Turn Rover: Turns the rover left or right, changing its direction.
- Method: Post
- Endpoint: http://localhost:8080/api/v1/rover/turn?direction=right
- Request Body: {}
  
4. Get Rover Position: Retrieves the current position of the rover on the tabletop.
- Method: Get
- Endpoint: http://localhost:8080/api/v1/rover/
- Request Body: {}


Refer to the API documentation or consult the application&#39;s Swagger documentation for more
details on request/response formats and error handling.
Swagger Documentation:
Once the application is up and running, swagger documentation can be found at
endpoint “http://localhost:8080/swagger-ui/index.html”

Known Issues
This Moon Rover Application has the following known issues:
1. No authentication or authorization mechanism is implemented.
2. Concurrent placement or movement of multiple rovers is not supported in this version.
# MoonRover-Fullstack

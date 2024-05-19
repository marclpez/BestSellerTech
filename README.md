# BestSellerTech

This document provides an overview of the Gamer API and how to use it.

## Getting Started

To get started with the Gamer API, follow these steps:

1. Clone the repository: `git clone https://github.com/your-repo.git`
2. Navigate to the project directory: `cd your-project`
3. Build the application: `./mvnw clean install`
4. Run the application: `./mvnw spring-boot:run`

The application will start running at `http://localhost:8080`.

## API Endpoints

The Gamer API provides the following endpoints:

### Get Gamers by Level per Game

- Endpoint: `/api/v1/gamer/level/{level}`
- Method: GET
- Description: Retrieves a list of gamers based on the specified level per game.
- Example: `http://localhost:8080/api/v1/gamer/level/INVINCIBLE`

### Search Gamers

- Endpoint: `/api/v1/gamer/search`
- Method: GET
- Description: Searches for gamers based on optional criteria.
- Example: `http://localhost:8080/api/v1/gamer/search?level=PRO&gameId=123&geographyId=456`

### Link Gamer to Game

- Endpoint: `/api/v1/gamerGame`
- Method: POST
- Description: Creates a relationship between a gamer and a game.
- Example: `http://localhost:8080/api/v1/gamerGame`
- Request Body:
  ```json
  {
    "gamerId": "789",
    "gameId": "123",
    "level": "N00B"
  }
  ```

## Docker Compose Configuration

The application includes a Docker Compose configuration (`docker-compose.yml`) that sets up the following services:

- Elasticsearch: A distributed search and analytics engine.
- Kibana: A visualization tool for exploring and analyzing data in Elasticsearch.
- Logstash: A data processing pipeline for ingesting, transforming, and sending data to Elasticsearch.

To start the services using Docker Compose, run the following command:

```
docker-compose up -d
```

This will start the services in detached mode. You can access the services at the following URLs:

- Elasticsearch: `http://localhost:9200`
- Kibana: `http://localhost:5601`
- Logstash: `http://localhost:5000`

## H2 Console

The application uses an embedded H2 database for storing data. You can access the H2 console to view and manage the database information.

To access the H2 console:

1. Start the application.
2. Open a web browser and go to `http://localhost:8080/h2-console`.
3. In the login form, enter the following details:
    - JDBC URL: `jdbc:h2:mem:testdb`
    - User Name: `game`
    - Password: (leave it empty)
4. Click on "Connect" to access the H2 console.

From the H2 console, you can view the database tables, execute SQL queries, and manage the data.

## Feedback and Support

If you have any questions, feedback, or issues regarding the Gamer API, please contact me.
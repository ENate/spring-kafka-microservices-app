# A spring-boot ecommerce kafka microservices app

This repository contains a spring boot microservices application implemented using the most recent Spring framework APIs. It is mostly written in Java, spring boot, kafka, mongodb, mysql, rabbitMQ and Kafka message brokers, ELK, etc.

# Tech Stack

- Spring Boot 2.7.3+
- JDK 11+
- Spring Security
- Spring Discovery
- Spring API Gateway
- Distributed tracing with zipkin and sleuth
- Spring Kafka and Kafka streams for messaging

# Databases

- MongoDB
- MySQL and PostgreSQL

## Other Tech Stack

- Authorization via Spring OAuth2 resource server
- Keycloack provides the authorization mechanism

## Others include

- Monitoring via Grafan and Prometheus
- Package and deploy using Docker and Kubernetes

## Steps to Run the Application

First, clone the repo as follows:

`https://github.com/ENate/spring-kafka-microservices-app.git`,

then run the ` docker-compose.yaml` file using the following command

`docker-compose up -d`

Next, run the following command to spin up keycloak and databases via docker-compose

`docker run --name keycloak_test -p 8181:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=password quay.io/keycloak/keycloak:18.0.0 start-dev`

Use any API platform (eg Postman, thunder client, Http etc) to perform CRUD operations on the endpoints. The naming of the individual services describe their main functions. For instance, The `product-service` represent the products in a given ecommerce application. Proceed with performing CRUD operations.

## Outstanding technologies

- Grafan and Prometheus for monitoring, etc
- Deployment using docker and kubernetes
- Add more services

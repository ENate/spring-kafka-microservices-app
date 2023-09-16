### Contents

This repository contains a spring boot microservices application implemented using the latest versions of Spring framework APIs. The implementation is based on the spring framework, boot3.0+, kafka, mongodb, mysql, rabbitMQ and Kafka message brokers, and monitoring via the micrometer tracing stack.

### Tech Stack

- Spring Boot 3.1.3+
- JDK 17+ (baseline for spring boot 3.0+)
- Spring Security (version 6.0+)
- Spring Discovery (based on the latest cloud version)
- Spring API Gateway
- Distributed tracing with zipkin and sleuth (all deprecated but replaces with micrometer tracing)
- Spring Kafka and Kafka streams for messaging

### Databases

- MongoDB
- MySQL and PostgreSQL

### Other Tech Stack

- Authorization via Spring OAuth2 resource server (via keycloak)
- Keycloack provides the authorization via OAuth2 & OIDC

### Others include

- Monitoring via Grafana and Prometheus
- Package and deploy using Docker and Kubernetes

### Steps to Run the Application

First, clone the repo as follows:

`https://github.com/ENate/spring-kafka-microservices-app.git`,

Assuming all the technology stack listed above are installed, change to the main directory and run as follows:

``` cd spring-kafka-microservices-app ``` and then do

``` mvn spring-boot:run ```

To run all services, we used the Google docker build API ``` jib``` and run the services using

 ` docker-compose.yaml` file using

`docker-compose up -d`

Next, run the following command to spin up keycloak and databases via docker-compose

`docker run --name keycloak_test -p 8181:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=password quay.io/keycloak/keycloak:18.0.0 start-dev`

Use any API platform (eg Postman, thunder client, Http etc) to perform CRUD operations on the endpoints. The naming of the individual services describe their main functions. For instance, The `product-service` represent the products in a given ecommerce application. Proceed with performing CRUD operations.

###  Other APIs 

- Grafana (visualization) and Prometheus (metrics), Tempo(traces), Loki (Logs) for monitoring and instrumentation
- Deployment using docker and kubernetes (still to be done)
- Updated services to use latest boot, security and cloud APIs

### Please Note
If you intend to save the docker images after build, please enter your username and set your password in the ```.m2/settings.xml`````` as described in the Google jib maven documentation.

You may do so by uncommenting this code snippet in the main `pom.xml` file and enter your username (for the docker registry):

`
<!-- Please change to your username -->
                    <!--to><image>registry.hub.docker.com/<user-name>/${artifactId}</image></to-->
`

# kafka-example-spring

Use this link to download and start the apache kafka https://kafka.apache.org/quickstart

It is recommend that we use Java 11 or newer.
## To start the consumer


```
cd Consumer
mvn spring-boot:run

```
Note: The consumer runs on port 8001
## Producer

```
cd Producer
mvn spring-boot:run
```

Note: The producer runs on port 8080


## To test the system

You can use the request below to send data to the producer, which will then send data to the consumer

```
curl --location 'localhost:8080/api/message' \
--header 'Content-Type: application/json' \
--data '{
    "message":"Hello message"
}'
```

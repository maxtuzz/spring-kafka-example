# Spring Kafka Example

### Running with Docker
1. Build java app `$ gradle clean build`

2. Build docker image `$ docker build -t asb-spring-kafka .`

3. Run service  
```
$ docker run -e KAFKA_GROUP_ID="whatever"
    \ -e KAFKA_SERVERS="whatever1,whatever2"
    \ -e CONSUMER_TOPIC="whatever"
    \ -e PRODUCER_TOPIC="whatever" 
    \ asb-spring-kafka 
```


### Test results 
Running locally call:

`$ curl -XPUT localhost:8080`

In testing, it takes between 4-8s to produce 40,000 large JSON based messages. 
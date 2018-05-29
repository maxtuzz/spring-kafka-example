# Spring Kafka Example

This is a basic Spring Boot project used to showcase a simplistic setup of a webservice that can be used to interact with Kafka as both a producer and consumer.

Created for ASB bank.  

### Running with Docker
1. Build java app `$ gradle clean build`

2. Build docker image `$ docker build -t asb-spring-kafka .`

3. Run service  
```
$ docker run -e KAFKA_GROUP_ID="whatever"
    \ -e KAFKA_SERVERS="whatever1,whatever2"
    \ -e CONSUMER_TOPIC="whatever"
    \ -e PRODUCER_TOPIC="whatever" 
    \ -e MESSAGE_COUNT="100000" 
    \ asb-spring-kafka 
```

### Configuration
##### Default values can be overwritten using the following environmental variables:
`KAFKA_SERVERS` 

Comma separated list of Kafka servers. Default: localhost

`CONSUMER_TOPIC`

Topic you want to consume. Default: `testTopic2`

`PRODUCER_TOPIC`

Topic you want to produce message for. Default: `testTopic`

`MESSAGE_COUNT` (integer)

For producer. How many JSON messages you want to send. Default: `100,000`

### Test Consumer 
Set `CONSUMER_TOPIC` to whatever topic you want to subscribe to. The listener will pick and print all message values to sysout. 

### Test Producer
Running locally call:

`$ curl -XPUT localhost:8080`


This will trigger a message onslaught.

In testing, it takes between 10-15 seconds to produce 100,000 large JSON based messages on a standard local developer setup.  
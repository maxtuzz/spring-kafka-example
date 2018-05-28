# Spring Kafka Example

`$ docker build -t asb-spring-kafka .`

```
$ docker run -e KAFKA_GROUP_ID="whatever"
    \ -e KAFKA_SERVERS="whatever1,whatever2"
    \ -e CONSUMER_TOPIC="whatever"
    \ -e PRODUCER_TOPIC="whatever" 
    \ asb-spring-kafka 
```
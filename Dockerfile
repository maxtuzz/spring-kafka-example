FROM openjdk:alpine

ADD build/libs/*.jar /opt/kafka-example.jar

WORKDIR /opt/
CMD java -jar kafka-example.jar
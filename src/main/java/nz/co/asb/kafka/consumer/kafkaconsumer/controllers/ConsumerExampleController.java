package nz.co.asb.kafka.consumer.kafkaconsumer.controllers;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

/**
 * Controller used for testing Spring kafka functionality
 *
 * @author Max Tuzzolino
 */

@Controller
public class ConsumerExampleController {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerExampleController.class);

    @KafkaListener(topics = "${consumer-topic}")
    public void consumeEvents(ConsumerRecord<?, ?> cr) {
        logger.info("------------------ MESSAGE ---------------------");
        logger.info("Message Received on Topic: " + cr.topic());
        logger.info(cr.value().toString());
        logger.info("------------------------------------------------");
    }
}
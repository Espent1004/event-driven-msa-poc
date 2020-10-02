package com.eventdrivenmsapoc.altinnservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.eventdrivenmsapoc.buildingblocks.abstractions.AbstractEvent;

@Service
public class MessageProducerImpl implements MessageProducer{

    @Autowired
    private KafkaTemplate<String, AbstractEvent> kafkaTemplate;

    @Value(value = "${loanapplications.topic.name}")
    private String topicName;

    public void publishEvent(AbstractEvent event) {
        Message<AbstractEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .build();

        kafkaTemplate.send(message);

    }
}

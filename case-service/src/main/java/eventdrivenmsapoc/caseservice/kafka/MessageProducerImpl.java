package eventdrivenmsapoc.caseservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.eventdrivenmsapoc.buildingblocks.abstractions.AbstractEvent;

@Service
public class MessageProducerImpl implements MessageProducer{

    @Autowired
    private KafkaTemplate<String, AbstractEvent> kafkaTemplate;

    @Value(value = "${cases.topic.name}")
    private String topicName;
    private static final String  EVENT_NAME = "event_name";

    public void publishEvent(AbstractEvent event) {

        Message<AbstractEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .setHeader(EVENT_NAME, event.getEventName())
                .build();

        kafkaTemplate.send(message);
    }

}

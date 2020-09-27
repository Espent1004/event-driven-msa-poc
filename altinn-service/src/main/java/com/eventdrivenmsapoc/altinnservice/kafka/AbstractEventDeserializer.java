package com.eventdrivenmsapoc.altinnservice.kafka;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import com.eventdrivenmsapoc.altinnservice.events.LoanApplicationCreatedEvent;
import com.eventdrivenmsapoc.altinnservice.events.LoanApplicationUpdatedEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AbstractEventDeserializer implements Deserializer<AbstractEvent> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public AbstractEvent deserialize(String s, byte[] bytes) {
        System.out.println(s);
        ObjectMapper mapper = new ObjectMapper();
        AbstractEvent event = null;
        try {
            event = mapper.readValue(bytes, AbstractEvent.class);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return event;
    }

    @Override
    public AbstractEvent deserialize(String topic, Headers headers, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        AbstractEvent event = null;
        Header[] headerArray = headers.toArray();
        Optional<Header> eventNameHeader = Arrays.stream(headerArray).filter(header -> header.key().equals("event_name")).findFirst();
        if(eventNameHeader.isEmpty()){
            return null;
        }
        String eventName = new String(eventNameHeader.get().value());
        try {
            switch (eventName) {
                case "LoanApplicationUpdatedEvent":
                    event = mapper.readValue(data, LoanApplicationUpdatedEvent.class);
                    break;
                case "LoanApplicationCreatedEvent":
                    event = mapper.readValue(data, LoanApplicationCreatedEvent.class);
                    break;
                default:
                    //Do nothing
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }

    @Override
    public void close() {

    }
}

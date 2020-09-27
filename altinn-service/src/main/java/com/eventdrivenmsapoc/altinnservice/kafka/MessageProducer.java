package com.eventdrivenmsapoc.altinnservice.kafka;

public interface MessageProducer {
    public void publishEvent(AbstractEvent event);
}

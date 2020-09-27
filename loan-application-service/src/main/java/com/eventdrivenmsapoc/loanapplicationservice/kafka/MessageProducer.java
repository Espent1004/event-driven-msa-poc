package com.eventdrivenmsapoc.loanapplicationservice.kafka;

public interface MessageProducer {
    public void publishEvent(AbstractEvent event);
}

package com.eventdrivenmsapoc.loanapplicationservice.kafka;

import com.eventdrivenmsapoc.buildingblocks.abstractions.AbstractEvent;

public interface MessageProducer {
    public void publishEvent(AbstractEvent event);
}

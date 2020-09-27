package com.eventdrivenmsapoc.altinnservice.kafka;

public interface EventHandler {
    public void handle(AbstractEvent event);
}

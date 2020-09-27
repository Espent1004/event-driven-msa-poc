package com.eventdrivenmsapoc.loanapplicationservice.kafka;

public abstract class AbstractEvent {
    private String userId;
    private String eventName;

    public AbstractEvent(String userId, String eventName) {
        this.userId = userId;
        this.eventName = eventName;
    }

    public AbstractEvent() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEventName() {
        return eventName;
    }
}

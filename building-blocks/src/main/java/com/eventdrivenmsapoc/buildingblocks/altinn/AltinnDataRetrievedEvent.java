package com.eventdrivenmsapoc.buildingblocks.altinn;

import com.eventdrivenmsapoc.buildingblocks.abstractions.AbstractEvent;

public class AltinnDataRetrievedEvent extends AbstractEvent {
    private AltinnData altinnData;
    private Long orderId;

    public AltinnDataRetrievedEvent() {
    }

    public AltinnDataRetrievedEvent(AltinnData altinnData, String userId, Long orderId) {
        super(userId, AltinnDataRetrievedEvent.class.getName());
        this.orderId = orderId;
        this.altinnData = altinnData;
    }

    public AltinnData getAltinnData() {
        return altinnData;
    }

    public void setAltinnData(AltinnData altinnData) {
        this.altinnData = altinnData;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "AltinnDataRetrievedEvent{" +
                "altinnData=" + altinnData +
                ", orderId=" + orderId +
                '}';
    }
}

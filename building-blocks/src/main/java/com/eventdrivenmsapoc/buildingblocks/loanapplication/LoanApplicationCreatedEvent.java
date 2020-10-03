package com.eventdrivenmsapoc.buildingblocks.loanapplication;

import com.eventdrivenmsapoc.buildingblocks.abstractions.AbstractEvent;


public class LoanApplicationCreatedEvent extends AbstractEvent {

    private String productType;
    private Long orderId;

    public LoanApplicationCreatedEvent() {
    }

    public LoanApplicationCreatedEvent(String productType, String userId, Long orderId) {
        super(userId, LoanApplicationCreatedEvent.class.getName());
        this.productType = productType;
        this.orderId = orderId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "LoanApplicationCreatedEvent{" +
                "productType='" + productType + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}


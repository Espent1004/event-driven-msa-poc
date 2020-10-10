package com.eventdrivenmsapoc.buildingblocks.cases;

import com.eventdrivenmsapoc.buildingblocks.abstractions.AbstractEvent;

public class CaseCreatedEvent extends AbstractEvent {

    private Long caseId;
    private String productType;
    private Long orderId;

    public CaseCreatedEvent() {
    }

    public CaseCreatedEvent(String productType, String userId, Long caseId, Long orderId) {
        super(userId, CaseCreatedEvent.class.getName());
        this.productType = productType;
        this.caseId = caseId;
        this.orderId = orderId;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
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
}

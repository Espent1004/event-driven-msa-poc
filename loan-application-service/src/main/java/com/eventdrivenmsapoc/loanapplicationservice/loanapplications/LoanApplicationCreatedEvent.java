package com.eventdrivenmsapoc.loanapplicationservice.loanapplications;

import java.util.UUID;

import com.eventdrivenmsapoc.loanapplicationservice.kafka.AbstractEvent;

public class LoanApplicationCreatedEvent extends AbstractEvent {

    private String productType;
    private String caseId;

    public LoanApplicationCreatedEvent(String productType, String userId) {
        super(userId, LoanApplicationCreatedEvent.class.getSimpleName());
        this.productType = productType;
        this.caseId = UUID.randomUUID().toString();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    @Override
    public String toString() {
        return "LoanApplicationCreatedEvent{" +
                "productType='" + productType + '\'' +
                ", caseId='" + caseId + '\'' +
                '}';
    }
}

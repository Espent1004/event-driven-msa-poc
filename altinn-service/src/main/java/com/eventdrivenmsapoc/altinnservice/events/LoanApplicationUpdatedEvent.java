package com.eventdrivenmsapoc.altinnservice.events;

import com.eventdrivenmsapoc.altinnservice.kafka.AbstractEvent;

public class LoanApplicationUpdatedEvent extends AbstractEvent {
    private String productType;
    private String caseId;
    private int equity;

    public LoanApplicationUpdatedEvent(String productType, String userId, String caseId, int equity) {
        super(userId, LoanApplicationUpdatedEvent.class.getSimpleName());
        this.productType = productType;
        this.caseId = caseId;
        this.equity = equity;
    }

    public LoanApplicationUpdatedEvent() {
        super();
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

    public int getEquity() {
        return equity;
    }

    public void setEquity(int equity) {
        this.equity = equity;
    }
}


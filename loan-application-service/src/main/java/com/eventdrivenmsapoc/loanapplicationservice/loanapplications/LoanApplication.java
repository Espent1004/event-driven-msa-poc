package com.eventdrivenmsapoc.loanapplicationservice.loanapplications;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "loan_application")
public class LoanApplication {

    private String productType;
    private Long userId;
    @Id
    @SequenceGenerator(name="loan_application_order_id_seq",
            sequenceName="loan_application_order_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="loan_application_order_id_seq")    private Long orderId;
    private Long caseId;

    public LoanApplication(String productType, Long userId, Long orderId, Long caseId) {
        this.productType = productType;
        this.userId = userId;
        this.orderId = orderId;
        this.caseId = caseId;
    }

    public LoanApplication() {

    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }
}

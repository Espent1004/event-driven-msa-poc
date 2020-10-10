package com.eventdrivenmsapoc.loanapplicationservice.loanapplications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.eventdrivenmsapoc.buildingblocks.cases.CaseCreatedEvent;

@Component
@KafkaListener(topics = "${cases.topic.name}")
public class CaseCreatedEventHandler {

    private final LoanApplicationService loanApplicationService;

    @Autowired
    public CaseCreatedEventHandler(LoanApplicationService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }

     @KafkaHandler
    public void handleCaseCreatedEvent(@Payload CaseCreatedEvent caseCreatedEvent) {
         loanApplicationService.updateLoanApplicationWithCaseId(caseCreatedEvent.getOrderId(), caseCreatedEvent.getCaseId());
     }
}

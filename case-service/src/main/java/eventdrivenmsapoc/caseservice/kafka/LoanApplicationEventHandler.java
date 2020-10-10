package eventdrivenmsapoc.caseservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.eventdrivenmsapoc.buildingblocks.loanapplication.LoanApplicationCreatedEvent;
import com.eventdrivenmsapoc.buildingblocks.loanapplication.LoanApplicationUpdatedEvent;

import eventdrivenmsapoc.caseservice.cases.CaseService;

@Component
@KafkaListener(topics = "${loanapplications.topic.name}")
public class LoanApplicationEventHandler {

    private final CaseService caseService;

    @Autowired
    public LoanApplicationEventHandler(CaseService caseService) {
        this.caseService = caseService;
    }

    @KafkaHandler
    public void handleLoanApplicationCreatedEvent(@Payload LoanApplicationCreatedEvent event) {
        caseService.createCase(event);
    }

}

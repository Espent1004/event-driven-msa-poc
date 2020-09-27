package com.eventdrivenmsapoc.loanapplicationservice.loanapplications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventdrivenmsapoc.loanapplicationservice.kafka.MessageProducer;

@RestController
@RequestMapping("loanapplications")
public class LoanApplicationResource {

    private final MessageProducer messageProducer;

    @Autowired
    public LoanApplicationResource(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping(path = "/case", consumes = "application/json", produces = "application/json")
    public void createLoanApplication() {
        messageProducer.publishEvent(new LoanApplicationCreatedEvent("HOUSE_LOAN", "1234"));
    }

    @PutMapping(path = "/case/{caseid}/update", consumes = "application/json", produces = "application/json")
    public void updateLoanApplication() {
        messageProducer.publishEvent(new LoanApplicationUpdatedEvent("HOUSE_LOAN", "1234", "45148", 100000));
    }
}

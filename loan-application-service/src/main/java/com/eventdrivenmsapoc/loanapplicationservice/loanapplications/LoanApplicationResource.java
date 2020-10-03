package com.eventdrivenmsapoc.loanapplicationservice.loanapplications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("loanapplications")
public class LoanApplicationResource {

    private final LoanApplicationService loanApplicationService;

    @Autowired
    public LoanApplicationResource(LoanApplicationService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }

    @PostMapping(path = "/case", consumes = "application/json", produces = "application/json")
    public LoanApplication createLoanApplication() {
        return loanApplicationService.createLoanApplication("HOUSE_LOAN", 123456789L);
    }

    @PutMapping(path = "/case/{caseid}/update", consumes = "application/json", produces = "application/json")
    public void updateLoanApplication() {
        //messageProducer.publishEvent(new LoanApplicationUpdatedEvent("HOUSE_LOAN", "1234", "45148", 100000));
    }
}

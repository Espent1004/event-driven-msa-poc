package com.eventdrivenmsapoc.loanapplicationservice.loanapplications;

public interface LoanApplicationService {
    LoanApplication createLoanApplication(String productType, Long userId);
}

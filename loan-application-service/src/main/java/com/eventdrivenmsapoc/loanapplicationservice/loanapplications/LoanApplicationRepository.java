package com.eventdrivenmsapoc.loanapplicationservice.loanapplications;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface LoanApplicationRepository extends PagingAndSortingRepository<LoanApplication, Long> {

}

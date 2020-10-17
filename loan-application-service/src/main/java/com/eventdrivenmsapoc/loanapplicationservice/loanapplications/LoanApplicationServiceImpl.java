package com.eventdrivenmsapoc.loanapplicationservice.loanapplications;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventdrivenmsapoc.buildingblocks.loanapplication.LoanApplicationCreatedEvent;
import com.eventdrivenmsapoc.loanapplicationservice.kafka.MessageProducer;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {

    private final MessageProducer messageProducer;
    private final LoanApplicationRepository loanApplicationRepository;
    private final Logger logger = LoggerFactory.getLogger(LoanApplicationServiceImpl.class);

    @Autowired
    public LoanApplicationServiceImpl(MessageProducer messageProducer,
            LoanApplicationRepository loanApplicationRepository) {
        this.messageProducer = messageProducer;
        this.loanApplicationRepository = loanApplicationRepository;
    }

    @Override
    public LoanApplication createLoanApplication(String productType, Long userId) {
        LoanApplication loanApplication = new LoanApplication(productType, userId, null,null);
        Long orderId = loanApplicationRepository.save(loanApplication).getOrderId();
        LoanApplicationCreatedEvent event = new LoanApplicationCreatedEvent(productType, userId.toString(), orderId);
        messageProducer.publishEvent(event);
        logger.info("Publishing event: {}", event);
        loanApplication.setOrderId(orderId);
        return loanApplication;
    }

    @Override
    public void updateLoanApplicationWithCaseId(Long orderId, Long caseId) {
        Optional<LoanApplication> optionalLoanApplication = loanApplicationRepository.findById(orderId);
        optionalLoanApplication.ifPresent(loanApplication -> {
            loanApplication.setCaseId(caseId);
            loanApplicationRepository.save(loanApplication);
        });
    }
}

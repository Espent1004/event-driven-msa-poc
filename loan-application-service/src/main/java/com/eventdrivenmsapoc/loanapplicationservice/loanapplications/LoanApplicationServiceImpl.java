package com.eventdrivenmsapoc.loanapplicationservice.loanapplications;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventdrivenmsapoc.buildingblocks.loanapplication.LoanApplicationCreatedEvent;
import com.eventdrivenmsapoc.loanapplicationservice.kafka.MessageProducer;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {

    private final MessageProducer messageProducer;
    private final LoanApplicationRepository loanApplicationRepository;

    @Autowired
    public LoanApplicationServiceImpl(MessageProducer messageProducer,
            LoanApplicationRepository loanApplicationRepository) {
        this.messageProducer = messageProducer;
        this.loanApplicationRepository = loanApplicationRepository;
    }

    //new Random().nextLong()
    @Override
    public LoanApplication createLoanApplication(String productType, Long userId) {
        LoanApplication loanApplication = new LoanApplication(productType, userId, null,null);
        Long orderId = loanApplicationRepository.save(loanApplication).getOrderId();
        messageProducer.publishEvent(new LoanApplicationCreatedEvent(productType, userId.toString(), orderId));
        loanApplication.setOrderId(orderId);
        return loanApplication;
    }
}

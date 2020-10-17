package com.eventdrivenmsapoc.altinnservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.eventdrivenmsapoc.altinnservice.altinn.AltinnService;
import com.eventdrivenmsapoc.buildingblocks.loanapplication.LoanApplicationCreatedEvent;
import com.eventdrivenmsapoc.buildingblocks.loanapplication.LoanApplicationUpdatedEvent;

@Component
@KafkaListener(topics = "${loanapplications.topic.name}")
public class LoanApplicationEventHandler {

    private final AltinnService altinnService;

    @Autowired
    public LoanApplicationEventHandler(AltinnService altinnService) {
        this.altinnService = altinnService;
    }

    @KafkaHandler
    public void handleLoanApplicationCreatedEvent(@Payload LoanApplicationCreatedEvent event) {
        altinnService.getAltinnData(event.getUserId(), event.getOrderId());
    }

    @KafkaHandler
    public void handleLoanApplicationUpdatedEvent(@Payload LoanApplicationUpdatedEvent event, @Headers MessageHeaders headers) {
        System.out.println(event);
        headers.keySet().forEach(key -> {
            System.out.println(headers.get(key));
        });
    }
}

package com.eventdrivenmsapoc.altinnservice.altinn;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventdrivenmsapoc.altinnservice.kafka.MessageProducer;
import com.eventdrivenmsapoc.buildingblocks.altinn.AltinnData;
import com.eventdrivenmsapoc.buildingblocks.altinn.AltinnDataRetrievedEvent;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.event.CircuitBreakerEvent;

@Service
public class AltinnServiceImpl implements AltinnService {

    private final AltinnProxy altinnProxy;
    private final MessageProducer messageProducer;
    private final Logger logger = LoggerFactory.getLogger(AltinnServiceImpl.class);

    CircuitBreakerConfig config = CircuitBreakerConfig.custom()
            .failureRateThreshold(50)
            .minimumNumberOfCalls(10)
            .build();

    CircuitBreakerRegistry registry = CircuitBreakerRegistry.of(config);
    CircuitBreaker circuitBreaker = registry.circuitBreaker("altinnProxy");


    @Autowired
    public AltinnServiceImpl(AltinnProxy altinnProxy, MessageProducer messageProducer) {
        this.altinnProxy = altinnProxy;
        this.messageProducer = messageProducer;
        circuitBreaker.getEventPublisher()
                .onCallNotPermitted(this::handleFailure)
                .onError(this::handleFailure);
    }

    @Override
    public AltinnData getAltinnData(String userId, Long orderId) {
        AltinnData altinnData = circuitBreaker.executeSupplier(altinnProxy::getTaxData);
        AltinnDataRetrievedEvent event = new AltinnDataRetrievedEvent(altinnData, userId, orderId);
        logger.info("Publishing event: {}", event);
        messageProducer.publishEvent(event);
        return altinnData;
    }

    private void handleFailure(CircuitBreakerEvent event) {
        System.out.println(event);
    }


}

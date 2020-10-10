package eventdrivenmsapoc.caseservice.cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventdrivenmsapoc.buildingblocks.cases.CaseCreatedEvent;
import com.eventdrivenmsapoc.buildingblocks.loanapplication.LoanApplicationCreatedEvent;

import eventdrivenmsapoc.caseservice.kafka.MessageProducer;

@Service
public class CaseServiceImpl implements CaseService {

    private final MessageProducer messageProducer;
    private final CaseRepository caseRepository;

    @Autowired
    public CaseServiceImpl(MessageProducer messageProducer, CaseRepository caseRepository) {
        this.messageProducer = messageProducer;
        this.caseRepository = caseRepository;
    }

    @Override
    public void createCase(LoanApplicationCreatedEvent event) {
        LoanCase loanCase = new LoanCase(event.getProductType());
        Long caseId = caseRepository.save(loanCase).getCaseId();
        CaseCreatedEvent caseCreatedEvent = new CaseCreatedEvent(event.getProductType(), event.getUserId(), caseId, event.getOrderId());
        messageProducer.publishEvent(caseCreatedEvent);
    }
}

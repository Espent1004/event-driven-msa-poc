package eventdrivenmsapoc.caseservice.cases;

import com.eventdrivenmsapoc.buildingblocks.loanapplication.LoanApplicationCreatedEvent;

public interface CaseService {
    void createCase(LoanApplicationCreatedEvent event);
}

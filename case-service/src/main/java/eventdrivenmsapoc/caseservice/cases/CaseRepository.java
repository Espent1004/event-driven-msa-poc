package eventdrivenmsapoc.caseservice.cases;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CaseRepository extends PagingAndSortingRepository<LoanCase, Long> {

}

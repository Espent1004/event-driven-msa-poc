package eventdrivenmsapoc.caseservice.cases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "loan_case")
public class LoanCase {

    @Id
    @SequenceGenerator(name="loan_case_case_id_seq",
            sequenceName="loan_case_case_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="loan_case_case_id_seq")
    private Long caseId;

    private String productType;

    public LoanCase() {
    }

    public LoanCase(String productType) {
        this.productType = productType;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}

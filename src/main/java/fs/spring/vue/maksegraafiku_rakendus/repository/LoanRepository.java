package fs.spring.vue.maksegraafiku_rakendus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fs.spring.vue.maksegraafiku_rakendus.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}

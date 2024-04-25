package fs.spring.vue.maksegraafiku_rakendus.service;

import fs.spring.vue.maksegraafiku_rakendus.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @PostConstruct
    public void init() {
    }

}
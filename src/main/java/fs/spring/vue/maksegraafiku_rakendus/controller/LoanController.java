package fs.spring.vue.maksegraafiku_rakendus.controller;

import fs.spring.vue.maksegraafiku_rakendus.Loan;
import fs.spring.vue.maksegraafiku_rakendus.model.EmiCalculatorRequest;
import fs.spring.vue.maksegraafiku_rakendus.model.EmiCalculatorResponse;
import fs.spring.vue.maksegraafiku_rakendus.model.EuriborResponse;
import fs.spring.vue.maksegraafiku_rakendus.repository.LoanRepository;
import fs.spring.vue.maksegraafiku_rakendus.service.EmiCalculatorService;
import fs.spring.vue.maksegraafiku_rakendus.service.EuriborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoanController {

    private final EmiCalculatorService emiCalculatorService;
    private final EuriborService euriborService;

    private static final Logger log = LoggerFactory.getLogger(EmiCalculatorService.class);


    @Autowired
    private LoanRepository loanRepository;

    public LoanController(EmiCalculatorService emiCalculatorService, EuriborService euriborService) {
        this.emiCalculatorService = emiCalculatorService;
        this.euriborService = euriborService;
    }

    @GetMapping("/loans")
    public ResponseEntity<List<Loan>> getAllLoans() {
        // Fetch all loans from your repository
        List<Loan> premadeLoans = loanRepository.findAll();

        return ResponseEntity.ok(premadeLoans);
    }

    @PostMapping(value = "/calculateEmi", produces = "application/json")
    public ResponseEntity<EmiCalculatorResponse> calculateEmi(@RequestBody EmiCalculatorRequest request) {

        EmiCalculatorResponse response = emiCalculatorService.calculateEmi(request).block();

        log.info("LoanController response: " + response);
        if (response == null) {
            throw new RuntimeException("Failed to calculate EMI");
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getEuribor")
    public ResponseEntity<EuriborResponse> getEuribor() {
        EuriborResponse response = euriborService.getEuribor().block();
        return ResponseEntity.ok(response);
    }
}
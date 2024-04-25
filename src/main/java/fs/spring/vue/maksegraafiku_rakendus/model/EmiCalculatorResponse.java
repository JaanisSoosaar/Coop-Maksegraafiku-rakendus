package fs.spring.vue.maksegraafiku_rakendus.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class EmiCalculatorResponse {
    @JsonProperty("emi")
    private double emi;
    @JsonProperty("emi_breakdown")
    private List<emi_breakdown> emi_breakdown;

    // getters and setters

    @Override
    public String toString() {
        return "EmiCalculatorResponse{" +
                "emi=" + emi +
                ", emi_breakdown=" + emi_breakdown +
                '}';
    }
}

class emi_breakdown {
    @JsonProperty("year")
    private int year;
    @JsonProperty("yearly_emi")
    private double yearly_emi;
    @JsonProperty("yearly_principal")
    private double yearly_principal;
    @JsonProperty("yearly_interest")
    private double yearly_interest;
    @JsonProperty("monthly_breakdown")
    private List<monthly_breakdown> monthly_breakdown;

    // getters and setters

    @Override
    public String toString() {
        return "emi_breakdown{" +
                "year=" + year +
                ", yearly_emi=" + yearly_emi +
                ", yearly_principal=" + yearly_principal +
                ", yearly_interest=" + yearly_interest +
                ", monthly_breakdown=" + monthly_breakdown +
                '}';
    }
}

class monthly_breakdown {
    @JsonProperty("month")
    private int month;
    @JsonProperty("monthly_emi")
    private double monthly_emi;
    @JsonProperty("monthly_principal")
    private double monthly_principal;
    @JsonProperty("monthly_interest")
    private double monthly_interest;
    @JsonProperty("remaining_loan_amount")
    private double remaining_loan_amount;

    // getters and setters

    @Override
    public String toString() {
        return "monthly_breakdown{" +
                "month=" + month +
                ", monthly_emi=" + monthly_emi +
                ", monthly_principal=" + monthly_principal +
                ", monthly_interest=" + monthly_interest +
                ", remaining_loan_amount=" + remaining_loan_amount +
                '}';
    }
}


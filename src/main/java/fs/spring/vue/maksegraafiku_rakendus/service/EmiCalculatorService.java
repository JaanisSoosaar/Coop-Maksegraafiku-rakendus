package fs.spring.vue.maksegraafiku_rakendus.service;
import org.springframework.stereotype.Service;
import fs.spring.vue.maksegraafiku_rakendus.model.EmiCalculatorRequest;
import fs.spring.vue.maksegraafiku_rakendus.model.EmiCalculatorResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmiCalculatorService {

    private final WebClient webClient;
    private static final Logger log = LoggerFactory.getLogger(EmiCalculatorService.class);


    public EmiCalculatorService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://smart-emi-calculator.p.rapidapi.com/").build();
    }


    public Mono<EmiCalculatorResponse> calculateEmi(EmiCalculatorRequest request) {
        return webClient.post()
                .uri(uriBuilder -> uriBuilder.path("/").build())
                .header("content-type", "application/json") /*x-www-form-urlencoded")*/
                .header("X-RapidAPI-Key", "YOUR_API_KEY_HERE")
                .header("X-RapidAPI-Host", "smart-emi-calculator.p.rapidapi.com")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(EmiCalculatorResponse.class)
                .onErrorResume(e -> {
                    log.error("Error calling API: ", e);
                    return Mono.empty();
                });
    }
}
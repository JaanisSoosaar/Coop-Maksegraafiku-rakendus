package fs.spring.vue.maksegraafiku_rakendus.service;

import fs.spring.vue.maksegraafiku_rakendus.model.EuriborResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EuriborService {

    private final WebClient webClient;
    private static final Logger log = LoggerFactory.getLogger(EuriborService.class);

    public EuriborService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://euribor.p.rapidapi.com/6m").build();
    }

    public Mono<EuriborResponse> getEuribor() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/").build())
                .header("X-RapidAPI-Key", "YOUR_API_KEY_HERE")
                .header("X-RapidAPI-Host", "euribor.p.rapidapi.com").retrieve()
                .bodyToMono(EuriborResponse.class)
                .onErrorResume(e -> {
                    log.error("Error calling API: ", e);
                    return Mono.empty();
                });
    }
}
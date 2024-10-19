package lab1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class ExternalApiController {

    private final WebClient webClient = WebClient.create();

    @GetMapping("/external-api")
    public Mono<String> callExternalApi() {
        String externalApiUrl = "https://jsonplaceholder.typicode.com/posts";

        return webClient.get()
                .uri(externalApiUrl)
                .retrieve()
                .bodyToMono(String.class);
    }
}


package br.com.ifba.client;

import br.com.ifba.dto.UsuarioGetResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UsuarioApiClient {

    private final WebClient webClient;

    public UsuarioApiClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    public UsuarioGetResponseDto buscarUsuarioExterno(Long id) {
        return webClient.get()
                .uri("/users/{id}", id)
                .retrieve()
                .bodyToMono(UsuarioGetResponseDto.class)
                .block(); // Bloqueia e aguarda a resposta (para código síncrono)
    }
}

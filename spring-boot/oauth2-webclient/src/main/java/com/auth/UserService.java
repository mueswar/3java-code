package com.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UserService {

    private final WebClient webClientProvider1;
    private final WebClient webClientProvider2;

    @Autowired
    public UserService(WebClient webClientProvider1, WebClient webClientProvider2) {
        this.webClientProvider1 = webClientProvider1;
        this.webClientProvider2 = webClientProvider2;
    }

    public Mono<List<User>> getUsersFromProvider1() {
        return webClientProvider1.get()
                .uri("https://api.provider1.com/users")
                .retrieve()
                .bodyToFlux(User.class)
                .collectList();
    }

    public Mono<List<User>> getUsersFromProvider2() {
        return webClientProvider2.get()
                .uri("https://api.provider2.com/users")
                .retrieve()
                .bodyToFlux(User.class)
                .collectList();
    }
}

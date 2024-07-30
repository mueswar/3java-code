package com.consumer.reactive_webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class ConsumerContoller {
    @Autowired
    private ProducerService producerService;

    @GetMapping("/consumers")
    public Mono<List<Item>> getConsumers(){
        return producerService.getItems();
    }

}

@Service
class ProducerService{
    private final WebClient webclient;
    ProducerService(WebClient.Builder builder){
        webclient =builder.baseUrl("http://localhost:8081").build();
    }

    public Mono<List<Item>> getItems(){
        return webclient.get().uri("/items")
                .retrieve()
                .bodyToFlux(Item.class)
                .collectList();

    }

}

record Item(int id, String name){}

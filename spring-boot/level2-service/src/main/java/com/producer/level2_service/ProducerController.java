package com.producer.level2_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProducerController {
    @GetMapping("/items")
    public List<Item> mone(){
        Item i = new Item(1, "one");
        var items = List.of(i);
        return items;
    }
}

record Item(int id, String name){}


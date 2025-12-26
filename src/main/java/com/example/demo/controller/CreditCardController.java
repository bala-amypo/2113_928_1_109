package com.example.demo.controller;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.service.CreditCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CreditCardController {

    private final CreditCardService service;

    public CreditCardController(CreditCardService service) {
        this.service = service;
    }

    @PostMapping
    public CreditCardRecord create(@RequestBody CreditCardRecord card) {
        return service.addCard(card);
    }

    @GetMapping
    public List<CreditCardRecord> getAll() {
        return service.getAllCards();
    }

    @GetMapping("/user/{userId}")
    public List<CreditCardRecord> getByUser(@PathVariable Long userId) {
        return service.getCardsByUser(userId);
    }

    @GetMapping("/test")
    public String test() {
        return "Credit card service working";
    }
}

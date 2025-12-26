package com.example.demo.controller;

import com.example.demo.service.CreditCardService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/test")
    public String test() {
        return "Credit card service working";
    }
}

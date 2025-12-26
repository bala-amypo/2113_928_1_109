package com.example.demo.controller;

import com.example.demo.entity.CreditCard;
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
    public CreditCard create(@RequestBody CreditCard card) {
        return service.addCard(card);
    }

    @GetMapping
    public List<CreditCard> getAll() {
        return service.getAllCards();
    }

    @GetMapping("/test")
    public String test() {
        return "Credit card service working";
    }
}

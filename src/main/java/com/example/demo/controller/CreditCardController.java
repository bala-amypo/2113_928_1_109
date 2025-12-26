package com.example.demo.controller;

import com.example.demo.service.CreditCardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards")
public class CreditCardController {

    private final CreditCardService cardService;

    public CreditCardController(CreditCardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/test")
    public String test() {
        return "CreditCard API working";
    }
}

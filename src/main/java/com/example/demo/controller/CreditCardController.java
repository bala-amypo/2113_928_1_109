package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CreditCardEntity;
import com.example.demo.repository.CreditCardRepository;

@RestController
@RequestMapping("/credit-cards")
public class CreditCardController {

    private final CreditCardRepository creditCardRepository;

    public CreditCardController(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @PostMapping
    public CreditCardEntity addCard(@RequestBody CreditCardEntity card) {
        return creditCardRepository.save(card);
    }

    @GetMapping
    public List<CreditCardEntity> getAllCards() {
        return creditCardRepository.findAll();
    }

    @GetMapping("/{id}")
    public CreditCardEntity getCardById(@PathVariable Long id) {
        return creditCardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credit card not found"));
    }

    @DeleteMapping("/{id}")
    public String deleteCard(@PathVariable Long id) {
        creditCardRepository.deleteById(id);
        return "Credit card deleted successfully ✅";
    }
}

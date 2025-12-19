package com.example.demo.controller;

import com.example.demo.entity.CreditCardEntity;
import com.example.demo.service.CreditCardService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CreditCardController {

    private final CreditCardService service;

    public CreditCardController(CreditCardService service) {
        this.service = service;
    }

    @PostMapping
    public CreditCardEntity create(@Valid @RequestBody CreditCardEntity card) {
        return service.createCard(card);
    }

    @GetMapping("/{id}")
    public CreditCardEntity getById(@PathVariable Long id) {
        return service.getCardById(id);
    }

    @GetMapping
    public List<CreditCardEntity> getAll() {
        return service.getAllCards();
    }

    @PutMapping("/{id}")
    public CreditCardEntity update(@PathVariable Long id,
                                   @Valid @RequestBody CreditCardEntity card) {
        return service.updateCard(id, card);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteCard(id);
        return "Card deleted successfully";
    }
}

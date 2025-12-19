package com.example.demo.controller;

import com.example.demo.entity.CreditCardEntity;
import com.example.demo.service.CreditCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit-cards")
public class CreditCardController {

private final CreditCardService creditCardService;

public CreditCardController(CreditCardService creditCardService) {
this.creditCardService = creditCardService;
}

@PostMapping
public CreditCardEntity save(@RequestBody CreditCardEntity card) {
return creditCardService.save(card);
}

@GetMapping
public List<CreditCardEntity> getAll() {
return creditCardService.getAll();
}
}

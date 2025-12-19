package com.example.demo.controller;

import com.example.demo.entity.PurchaseIntentEntity;
import com.example.demo.service.PurchaseIntentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase-intents")
public class PurchaseIntentController {

private final PurchaseIntentService purchaseIntentService;

public PurchaseIntentController(PurchaseIntentService purchaseIntentService) {
this.purchaseIntentService = purchaseIntentService;
}

@PostMapping
public PurchaseIntentEntity save(@RequestBody PurchaseIntentEntity intent) {
return purchaseIntentService.save(intent);
}

@GetMapping
public List<PurchaseIntentEntity> getAll() {
return purchaseIntentService.getAll();
}
}

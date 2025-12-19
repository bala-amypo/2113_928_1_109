package com.example.demo.controller;

import com.example.demo.entity.PurchaseIntentEntity;
import com.example.demo.service.PurchaseIntentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase-intents")
public class PurchaseIntentController {

    private final PurchaseIntentService service;

    public PurchaseIntentController(PurchaseIntentService service) {
        this.service = service;
    }

    @PostMapping
    public PurchaseIntentEntity save(@RequestBody PurchaseIntentEntity entity) {
        return service.save(entity);
    }

    @GetMapping
    public List<PurchaseIntentEntity> getAll() {
        return service.getAll();
    }
}

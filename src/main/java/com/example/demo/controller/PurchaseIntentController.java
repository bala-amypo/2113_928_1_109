package com.example.demo.controller;

import com.example.demo.entity.PurchaseIntentEntity;
import com.example.demo.service.PurchaseIntentService;
import jakarta.validation.Valid;
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
    public PurchaseIntentEntity create(@Valid @RequestBody PurchaseIntentEntity intent) {
        return service.createIntent(intent);
    }

    @GetMapping("/{id}")
    public PurchaseIntentEntity getById(@PathVariable Long id) {
        return service.getIntentById(id);
    }

    @GetMapping
    public List<PurchaseIntentEntity> getAll() {
        return service.getAllIntents();
    }

    @PutMapping("/{id}")
    public PurchaseIntentEntity update(@PathVariable Long id,
                                       @Valid @RequestBody PurchaseIntentEntity intent) {
        return service.updateIntent(id, intent);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteIntent(id);
        return "Purchase intent deleted successfully";
    }
}

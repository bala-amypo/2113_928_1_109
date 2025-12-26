package com.example.demo.controller;

import com.example.demo.entity.PurchaseIntentRecord;
import com.example.demo.service.PurchaseIntentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-intents")
public class PurchaseIntentController {

    private final PurchaseIntentService service;

    public PurchaseIntentController(PurchaseIntentService service) {
        this.service = service;
    }

    @PostMapping
    public PurchaseIntentRecord create(@RequestBody PurchaseIntentRecord intent) {
        return service.createIntent(intent);
    }

    @GetMapping
    public List<PurchaseIntentRecord> getAll() {
        return service.getAllIntents();
    }

    @GetMapping("/test")
    public String test() {
        return "Purchase intent service working";
    }
}

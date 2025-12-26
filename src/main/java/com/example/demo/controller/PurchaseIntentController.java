package com.example.demo.controller;

import com.example.demo.service.PurchaseIntentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/purchase-intents")
public class PurchaseIntentController {

    private final PurchaseIntentService intentService;

    public PurchaseIntentController(PurchaseIntentService intentService) {
        this.intentService = intentService;
    }

    @GetMapping("/test")
    public String test() {
        return "PurchaseIntent API working";
    }
}

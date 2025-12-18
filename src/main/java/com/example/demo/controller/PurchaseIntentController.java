package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.PurchaseIntentity;
import com.example.demo.repository.PurchaseIntentityRepository;

@RestController
@RequestMapping("/purchases")
public class PurchaseIntentityController {

    private final PurchaseIntentityRepository purchaseRepo;

    public PurchaseIntentityController(PurchaseIntentityRepository purchaseRepo) {
        this.purchaseRepo = purchaseRepo;
    }

    @PostMapping
    public PurchaseIntentity addPurchase(@RequestBody PurchaseIntentity purchase) {
        if (purchase.getAmount() <= 0) {
            throw new RuntimeException("Purchase amount must be greater than zero");
        }
        return purchaseRepo.save(purchase);
    }

    @GetMapping
    public List<PurchaseIntentity> getAllPurchases() {
        return purchaseRepo.findAll();
    }

    @GetMapping("/{id}")
    public PurchaseIntentity getPurchaseById(@PathVariable Long id) {
        return purchaseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));
    }
}

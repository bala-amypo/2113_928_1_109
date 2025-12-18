package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.PurchaseIntentity;
import com.example.demo.entity.UserProfileEntity;
import com.example.demo.repository.PurchaseIntentityRepository;

@Service
public class PurchaseIntentityServiceImpl {

    private final PurchaseIntentityRepository purchaseRepository;

    public PurchaseIntentityServiceImpl(PurchaseIntentityRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public PurchaseIntentity addPurchase(PurchaseIntentity purchase) {
        if (purchase.getAmount() <= 0) {
            throw new RuntimeException("Purchase amount must be greater than zero");
        }
        return purchaseRepository.save(purchase);
    }

    public List<PurchaseIntentity> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public List<PurchaseIntentity> getPurchasesByUser(UserProfileEntity user) {
        return purchaseRepository.findByUser(user);
    }

    public PurchaseIntentity getPurchaseById(Long id) {
        return purchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));
    }
}

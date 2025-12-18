package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.PurchaseIntentity;
import com.example.demo.entity.UserProfileEntity;

public interface PurchaseIntentityService {

    PurchaseIntentity addPurchase(PurchaseIntentity purchase);

    List<PurchaseIntentity> getAllPurchases();

    List<PurchaseIntentity> getPurchasesByUser(UserProfileEntity user);

    PurchaseIntentity getPurchaseById(Long id);
}

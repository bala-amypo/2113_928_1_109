package com.example.demo.service;

import com.example.demo.entity.PurchaseIntentEntity;
import java.util.List;

public interface PurchaseIntentService {

    PurchaseIntentEntity createIntent(PurchaseIntentEntity intent);
    PurchaseIntentEntity getIntentById(Long id);
    List<PurchaseIntentEntity> getAllIntents();
    PurchaseIntentEntity updateIntent(Long id, PurchaseIntentEntity intent);
    void deleteIntent(Long id);
}

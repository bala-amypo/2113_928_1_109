package com.example.demo.service;

import com.example.demo.entity.PurchaseIntentEntity;
import java.util.List;

public interface PurchaseIntentService {
    PurchaseIntentEntity save(PurchaseIntentEntity entity);
    List<PurchaseIntentEntity> getAll();
}

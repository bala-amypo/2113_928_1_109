package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseIntentEntity;
import com.example.demo.repository.PurchaseIntentRepository;
import com.example.demo.service.PurchaseIntentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseIntentServiceImpl implements PurchaseIntentService {

    private final PurchaseIntentRepository repository;

    public PurchaseIntentServiceImpl(PurchaseIntentRepository repository) {
        this.repository = repository;
    }

    @Override
    public PurchaseIntentEntity save(PurchaseIntentEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<PurchaseIntentEntity> getAll() {
        return repository.findAll();
    }
}

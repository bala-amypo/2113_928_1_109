package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseIntentEntity;
import com.example.demo.exception.ResourceNotFoundException;
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
    public PurchaseIntentEntity createIntent(PurchaseIntentEntity intent) {
        return repository.save(intent);
    }

    @Override
    public PurchaseIntentEntity getIntentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase intent not found with id " + id));
    }

    @Override
    public List<PurchaseIntentEntity> getAllIntents() {
        return repository.findAll();
    }

    @Override
    public PurchaseIntentEntity updateIntent(Long id, PurchaseIntentEntity intent) {
        PurchaseIntentEntity existing = getIntentById(id);
        existing.setAmount(intent.getAmount());
        existing.setCategory(intent.getCategory());
        existing.setMerchant(intent.getMerchant());
        return repository.save(existing);
    }

    @Override
    public void deleteIntent(Long id) {
        repository.delete(getIntentById(id));
    }
}

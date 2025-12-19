package com.example.demo.service.impl;

import com.example.demo.entity.CreditCardEntity;
import com.example.demo.repository.CreditCardRepository;
import com.example.demo.service.CreditCardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository repository;

    public CreditCardServiceImpl(CreditCardRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreditCardEntity save(CreditCardEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<CreditCardEntity> getAll() {
        return repository.findAll();
    }
}

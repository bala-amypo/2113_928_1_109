package com.example.demo.service.impl;

import com.example.demo.entity.CreditCardEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CreditCardRepository;
import com.example.demo.service.CreditCardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional   // Enables transaction management for all methods in this class
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository repository;

    public CreditCardServiceImpl(CreditCardRepository repository) {
        this.repository = repository;
    }

    // Create a new credit card (WRITE operation)
    @Override
    public CreditCardEntity createCard(CreditCardEntity card) {
        return repository.save(card);
    }

    // Get credit card by ID (READ operation)
    @Override
    @Transactional(readOnly = true)
    public CreditCardEntity getCardById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Card not found with id " + id));
    }

    // Get all credit cards (READ operation)
    @Override
    @Transactional(readOnly = true)
    public List<CreditCardEntity> getAllCards() {
        return repository.findAll();
    }

    // Update an existing credit card (WRITE operation)
    @Override
    public CreditCardEntity updateCard(Long id, CreditCardEntity card) {
        CreditCardEntity existing = getCardById(id);
        existing.setCardName(card.getCardName());
        existing.setIssuer(card.getIssuer());
        existing.setCardType(card.getCardType());
        return repository.save(existing);
    }

    // Delete a credit card by ID (WRITE operation)
    @Override
    public void deleteCard(Long id) {
        repository.delete(getCardById(id));
    }
}

package com.example.demo.service.impl;

import com.example.demo.entity.CreditCardEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CreditCardRepository;
import com.example.demo.service.CreditCardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository repository;

    public CreditCardServiceImpl(CreditCardRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public CreditCardEntity createCard(CreditCardEntity card) {
        return repository.save(card);
    }

    @Override
    @Transactional(readOnly = true)
    public CreditCardEntity getCardById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Card not found with id " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CreditCardEntity> getAllCards() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public CreditCardEntity updateCard(Long id, CreditCardEntity card) {
        CreditCardEntity existing = getCardById(id);
        existing.setCardName(card.getCardName());
        existing.setIssuer(card.getIssuer());
        existing.setCardType(card.getCardType());
        return repository.save(existing);
    }

    @Override
    @Transactional
    public void deleteCard(Long id) {
        repository.delete(getCardById(id));
    }
}

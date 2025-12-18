package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CreditCardEntity;
import com.example.demo.repository.CreditCardRepository;

@Service
public class CreditCardServiceImpl {

    private final CreditCardRepository creditCardRepository;

    public CreditCardServiceImpl(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public CreditCardEntity addCard(CreditCardEntity card) {
        if (creditCardRepository.existsByCardName(card.getCardName())) {
            throw new RuntimeException("Credit card already exists");
        }
        return creditCardRepository.save(card);
    }

    public List<CreditCardEntity> getAllCards() {
        return creditCardRepository.findAll();
    }

    public CreditCardEntity getCardById(Long id) {
        return creditCardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credit card not found"));
    }

    public void deleteCard(Long id) {
        creditCardRepository.deleteById(id);
    }
}

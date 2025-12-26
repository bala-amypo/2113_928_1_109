package com.example.demo.service.impl;

import com.example.demo.entity.CreditCardRecord;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CreditCardRecordRepository;
import com.example.demo.service.CreditCardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRecordRepository repo;

    public CreditCardServiceImpl(CreditCardRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public CreditCardRecord addCard(CreditCardRecord card) {
        if (card.getAnnualFee() != null && card.getAnnualFee() < 0) {
            throw new BadRequestException("Annual fee must be non-negative");
        }
        return repo.save(card);
    }

    @Override
    public CreditCardRecord updateCard(Long id, CreditCardRecord updated) {
        CreditCardRecord existing = getCardById(id);
        updated.setId(existing.getId());
        return repo.save(updated);
    }

    @Override
    public CreditCardRecord getCardById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Card not found"));
    }

    @Override
    public List<CreditCardRecord> getCardsByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public List<CreditCardRecord> getAllCards() {
        return repo.findAll();
    }
}

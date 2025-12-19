package com.example.demo.service;

import com.example.demo.entity.CreditCardEntity;
import java.util.List;

public interface CreditCardService {

    CreditCardEntity createCard(CreditCardEntity card);
    CreditCardEntity getCardById(Long id);
    List<CreditCardEntity> getAllCards();
    CreditCardEntity updateCard(Long id, CreditCardEntity card);
    void deleteCard(Long id);
}

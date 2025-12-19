package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.CreditCardEntity;

public interface CreditCardService {

    CreditCardEntity addCard(CreditCardEntity card);

    List<CreditCardEntity> getAllCards();

    CreditCardEntity getCardById(Long id);

    void deleteCard(Long id);
}

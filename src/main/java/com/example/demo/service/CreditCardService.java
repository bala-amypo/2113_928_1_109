package com.example.demo.service;

import com.example.demo.entity.CreditCardEntity;
import java.util.List;

public interface CreditCardService {
    CreditCardEntity save(CreditCardEntity entity);
    List<CreditCardEntity> getAll();
}

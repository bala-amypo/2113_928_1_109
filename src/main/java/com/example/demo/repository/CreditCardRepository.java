package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.CreditCardEntity;

public interface CreditCardRepository
        extends JpaRepository<CreditCardEntity, Long> {

    boolean existsByCardName(String cardName);
}

package com.example.demo.repository;

import com.example.demo.entity.CreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCardEntity, Long> {
}

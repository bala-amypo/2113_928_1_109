package com.example.demo.repository;

import com.example.demo.entity.CreditCardRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CreditCardRecordRepository
        extends JpaRepository<CreditCardRecord, Long> {

    // Used in tests 15, 46
    List<CreditCardRecord> findByUserId(Long userId);

    // Used in recommendation engine tests
    @Query("""
           SELECT c FROM CreditCardRecord c
           WHERE c.userId = :userId
           AND c.status = 'ACTIVE'
           """)
    List<CreditCardRecord> findActiveCardsByUser(@Param("userId") Long userId);
}

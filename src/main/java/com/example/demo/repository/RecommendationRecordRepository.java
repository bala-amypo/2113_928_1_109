package com.example.demo.repository;

import com.example.demo.entity.RecommendationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationRecordRepository
        extends JpaRepository<RecommendationRecord, Long> {

    // Tests 48, 62
    List<RecommendationRecord> findByUserId(Long userId);
}

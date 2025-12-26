package com.example.demo.repository;

import com.example.demo.entity.RewardRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RewardRuleRepository extends JpaRepository<RewardRule, Long> {

    // Test 57
    List<RewardRule> findByActiveTrue();

    // Recommendation engine
    @Query("""
           SELECT r FROM RewardRule r
           WHERE r.cardId = :cardId
           AND r.category = :category
           AND r.active = true
           """)
    List<RewardRule> findActiveRulesForCardCategory(
            @Param("cardId") Long cardId,
            @Param("category") String category
    );
}

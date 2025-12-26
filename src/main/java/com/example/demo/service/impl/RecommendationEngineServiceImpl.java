package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.RecommendationEngineService;

import java.util.Comparator;
import java.util.List;

@Service 
public class RecommendationEngineServiceImpl
        implements RecommendationEngineService {

    private final PurchaseIntentRecordRepository intentRepo;
    private final UserProfileRepository userRepo;
    private final CreditCardRecordRepository cardRepo;
    private final RewardRuleRepository ruleRepo;
    private final RecommendationRecordRepository recRepo;

    public RecommendationEngineServiceImpl(
            PurchaseIntentRecordRepository intentRepo,
            UserProfileRepository userRepo,
            CreditCardRecordRepository cardRepo,
            RewardRuleRepository ruleRepo,
            RecommendationRecordRepository recRepo) {

        this.intentRepo = intentRepo;
        this.userRepo = userRepo;
        this.cardRepo = cardRepo;
        this.ruleRepo = ruleRepo;
        this.recRepo = recRepo;
    }

    @Override
    public RecommendationRecord generateRecommendation(Long intentId) {

        // 1. Fetch intent
        PurchaseIntentRecord intent = intentRepo.findById(intentId)
                .orElseThrow(() -> new ResourceNotFoundException("Intent not found"));

        // 2. Fetch user
        UserProfile user = userRepo.findById(intent.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // 3. Fetch active cards
        List<CreditCardRecord> cards =
                cardRepo.findActiveCardsByUser(user.getId());

        if (cards.isEmpty()) {
            throw new BadRequestException("No active cards");
        }

        // 4–6. Evaluate rules & pick best reward
        CreditCardRecord bestCard = null;
        double bestReward = 0.0;

        for (CreditCardRecord card : cards) {
            List<RewardRule> rules =
                    ruleRepo.findActiveRulesForCardCategory(
                            card.getId(), intent.getCategory());

            for (RewardRule rule : rules) {
                double reward = intent.getAmount() * rule.getMultiplier();
                if (reward > bestReward) {
                    bestReward = reward;
                    bestCard = card;
                }
            }
        }

        // 7. Save recommendation
        RecommendationRecord rec = new RecommendationRecord();
        rec.setUserId(user.getId());
        rec.setPurchaseIntentId(intent.getId());
        rec.setRecommendedCardId(bestCard.getId());
        rec.setExpectedRewardValue(bestReward);

        return recRepo.save(rec);
    }

    @Override
    public List<RecommendationRecord> getRecommendationsByUser(Long userId) {
        return recRepo.findByUserId(userId);
    }

    @Override
    public List<RecommendationRecord> getAllRecommendations() {
        return recRepo.findAll();
    }
}

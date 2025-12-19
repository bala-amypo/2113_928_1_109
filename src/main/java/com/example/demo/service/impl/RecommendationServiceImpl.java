package com.example.demo.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CreditCardEntity;
import com.example.demo.entity.RecommendationEntity;
import com.example.demo.entity.UserProfileEntity;
import com.example.demo.repository.CreditCardRepository;
import com.example.demo.repository.RecommendationRepository;

@Service
public class RecommendationServiceImpl {

    private final RecommendationRepository recommendationRepository;
    private final CreditCardRepository creditCardRepository;

    public RecommendationServiceImpl(RecommendationRepository recommendationRepository,
                                     CreditCardRepository creditCardRepository) {
        this.recommendationRepository = recommendationRepository;
        this.creditCardRepository = creditCardRepository;
    }

    // CORE LOGIC: find best credit card
    public RecommendationEntity recommendBestCard(UserProfileEntity user,
                                                   Double purchaseAmount) {

        List<CreditCardEntity> cards = creditCardRepository.findAll();

        CreditCardEntity bestCard = cards.stream()
                .max(Comparator.comparing(
                        c -> c.getRewardRate() * purchaseAmount
                ))
                .orElseThrow(() -> new RuntimeException("No cards available"));

        RecommendationEntity recommendation = new RecommendationEntity();
        recommendation.setUser(user);
        recommendation.setRecommendedCard(bestCard);
        recommendation.setExpectedReward(
                bestCard.getRewardRate() * purchaseAmount
        );

        return recommendationRepository.save(recommendation);
    }

    public List<RecommendationEntity> getAllRecommendations() {
        return recommendationRepository.findAll();
    }
}

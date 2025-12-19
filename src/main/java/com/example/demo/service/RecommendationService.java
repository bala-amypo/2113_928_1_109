package com.example.demo.service;

import com.example.demo.entity.RecommendationEntity;
import java.util.List;

public interface RecommendationService {

    RecommendationEntity createRecommendation(RecommendationEntity recommendation);
    RecommendationEntity getRecommendationById(Long id);
    List<RecommendationEntity> getAllRecommendations();
    void deleteRecommendation(Long id);
}

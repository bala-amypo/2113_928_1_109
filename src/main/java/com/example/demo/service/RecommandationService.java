package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.RecommendationEntity;
import com.example.demo.entity.UserProfileEntity;

public interface RecommendationService {

    RecommendationEntity recommendBestCard(UserProfileEntity user,
                                            Double purchaseAmount);

    List<RecommendationEntity> getAllRecommendations();
}

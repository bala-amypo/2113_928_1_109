package com.example.demo.service;

import com.example.demo.entity.RecommendationEntity;
import java.util.List;

public interface RecommendationService {
    RecommendationEntity save(RecommendationEntity entity);
    List<RecommendationEntity> getAll();
}

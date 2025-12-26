package com.example.demo.controller;

import com.example.demo.service.RecommendationEngineService;

public class RecommendationController {

    private final RecommendationEngineService recommendationService;

    public RecommendationController(RecommendationEngineService recommendationService) {
        this.recommendationService = recommendationService;
    }
}


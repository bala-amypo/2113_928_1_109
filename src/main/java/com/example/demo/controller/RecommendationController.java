package com.example.demo.controller;

import com.example.demo.service.RecommendationEngineService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationEngineService recommendationService;

    public RecommendationController(RecommendationEngineService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/test")
    public String test() {
        return "Recommendation API working";
    }
}

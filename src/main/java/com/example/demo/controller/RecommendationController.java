package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RecommendationEntity;
import com.example.demo.repository.RecommendationRepository;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    private final RecommendationRepository recommendationRepo;

    public RecommendationController(RecommendationRepository recommendationRepo) {
        this.recommendationRepo = recommendationRepo;
    }

    @PostMapping
    public RecommendationEntity saveRecommendation(
            @RequestBody RecommendationEntity recommendation) {
        return recommendationRepo.save(recommendation);
    }

    @GetMapping
    public List<RecommendationEntity> getAllRecommendations() {
        return recommendationRepo.findAll();
    }

    @GetMapping("/{id}")
    public RecommendationEntity getRecommendationById(@PathVariable Long id) {
        return recommendationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Recommendation not found"));
    }
}

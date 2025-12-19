package com.example.demo.controller;

import com.example.demo.entity.RecommendationEntity;
import com.example.demo.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    private final RecommendationService service;

    public RecommendationController(RecommendationService service) {
        this.service = service;
    }

    @PostMapping
    public RecommendationEntity create(@RequestBody RecommendationEntity recommendation) {
        return service.createRecommendation(recommendation);
    }

    @GetMapping("/{id}")
    public RecommendationEntity getById(@PathVariable Long id) {
        return service.getRecommendationById(id);
    }

    @GetMapping
    public List<RecommendationEntity> getAll() {
        return service.getAllRecommendations();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteRecommendation(id);
        return "Recommendation deleted successfully";
    }
}

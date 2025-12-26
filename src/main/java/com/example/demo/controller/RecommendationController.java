package com.example.demo.controller;

import com.example.demo.entity.RecommendationRecord;
import com.example.demo.service.RecommendationEngineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationEngineService service;

    public RecommendationController(RecommendationEngineService service) {
        this.service = service;
    }

    @PostMapping("/{intentId}")
    public RecommendationRecord generate(@PathVariable Long intentId) {
        return service.generateRecommendation(intentId);
    }

    @GetMapping
    public List<RecommendationRecord> getAll() {
        return service.getAllRecommendations();
    }

    @GetMapping("/user/{userId}")
    public List<RecommendationRecord> getByUser(@PathVariable Long userId) {
        return service.getRecommendationsByUser(userId);
    }

    @GetMapping("/test")
    public String test() {
        return "Recommendation service working";
    }
}

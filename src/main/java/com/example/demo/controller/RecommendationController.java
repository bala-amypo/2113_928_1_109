package com.example.demo.controller;

import com.example.demo.entity.RecommendationEntity;
import com.example.demo.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

private final RecommendationService recommendationService;

public RecommendationController(RecommendationService recommendationService) {
this.recommendationService = recommendationService;
}

@GetMapping
public List<RecommendationEntity> getAll() {
return recommendationService.getAll();
}
}

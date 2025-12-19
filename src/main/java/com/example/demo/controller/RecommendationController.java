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
    public RecommendationEntity save(@RequestBody RecommendationEntity entity) {
        return service.save(entity);
    }

    @GetMapping
    public List<RecommendationEntity> getAll() {
        return service.getAll();
    }
}

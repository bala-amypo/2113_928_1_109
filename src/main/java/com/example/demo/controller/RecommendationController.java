package com.example.demo.controller;

import com.example.demo.service.RecommendationEngineService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService service;

    public RecommendationController(RecommendationService service) {
        this.service = service;
    }

    @GetMapping("/test")
    public String test() {
        return "Recommendation service working";
    }
}

package com.example.demo.controller;

import com.example.demo.service.RecommendationEngineService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationEngineService service;

    public RecommendationController(RecommendationEngineService service) {
        this.service = service;
    }

    @GetMapping("/test")
    public String test() {
        return "Recommendation service working";
    }
}

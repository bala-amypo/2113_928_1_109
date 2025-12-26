package com.example.demo.controller;

import com.example.demo.entity.RewardRule;
import com.example.demo.service.RewardRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reward-rules")
public class RewardRuleController {

    private final RewardRuleService service;

    public RewardRuleController(RewardRuleService service) {
        this.service = service;
    }

    @PostMapping
    public RewardRule create(@RequestBody RewardRule rule) {
        return service.createRule(rule);
    }

    @GetMapping("/active")
    public List<RewardRule> active() {
        return service.getActiveRules();
    }

    @GetMapping
    public List<RewardRule> all() {
        return service.getAllRules();
    }
}

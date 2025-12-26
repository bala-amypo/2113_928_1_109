package com.example.demo.controller;

import com.example.demo.entity.RewardRule;
import com.example.demo.service.RewardRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardRuleController {

    private final RewardRuleService service;

    public RewardRuleController(RewardRuleService service) {
        this.service = service;
    }

    @PostMapping
    public RewardRule create(@RequestBody RewardRule rule) {
        return service.createRule(rule);
    }

    @GetMapping
    public List<RewardRule> getAll() {
        return service.getAllRules();
    }

    @GetMapping("/active")
    public List<RewardRule> getActive() {
        return service.getActiveRules();
    }

    @GetMapping("/test")
    public String test() {
        return "Reward rule service working";
    }
}

package com.example.demo.controller;

import com.example.demo.service.RewardRuleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rewards")
public class RewardRuleController {

    private final RewardRuleService ruleService;

    public RewardRuleController(RewardRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @GetMapping("/test")
    public String test() {
        return "RewardRule API working";
    }
}

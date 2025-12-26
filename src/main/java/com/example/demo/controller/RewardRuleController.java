package com.example.demo.controller;

import com.example.demo.service.RewardRuleService;

public class RewardRuleController {

    private final RewardRuleService ruleService;

    public RewardRuleController(RewardRuleService ruleService) {
        this.ruleService = ruleService;
    }
}

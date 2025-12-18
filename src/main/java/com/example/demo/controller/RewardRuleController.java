package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.RewardRuleEntity;
import com.example.demo.service.RewardRuleService;

@RestController
@RequestMapping("/reward-rules")
public class RewardRuleController {

    private final RewardRuleService rewardRuleService;

    public RewardRuleController(RewardRuleService rewardRuleService) {
        this.rewardRuleService = rewardRuleService;
    }

    @PostMapping
    public RewardRuleEntity create(@RequestBody RewardRuleEntity rule) {
        return rewardRuleService.createRule(rule);
    }

    @GetMapping
    public List<RewardRuleEntity> getAll() {
        return rewardRuleService.getAllRules();
    }

    @GetMapping("/{id}")
    public RewardRuleEntity getById(@PathVariable Long id) {
        return rewardRuleService.getRuleById(id);
    }

    @PutMapping("/{id}")
    public RewardRuleEntity update(@PathVariable Long id,
                                   @RequestBody RewardRuleEntity rule) {
        return rewardRuleService.updateRule(id, rule);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        rewardRuleService.deleteRule(id);
        return "Reward rule deleted successfully ✅";
    }
}

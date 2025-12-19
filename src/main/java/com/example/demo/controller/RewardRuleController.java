package com.example.demo.controller;

import com.example.demo.entity.RewardRuleEntity;
import com.example.demo.service.RewardRuleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reward-rules")
public class RewardRuleController {

    private final RewardRuleService service;

    public RewardRuleController(RewardRuleService service) {
        this.service = service;
    }

    @PostMapping
    public RewardRuleEntity create(@Valid @RequestBody RewardRuleEntity rule) {
        return service.createRule(rule);
    }

    @GetMapping("/{id}")
    public RewardRuleEntity getById(@PathVariable Long id) {
        return service.getRuleById(id);
    }

    @GetMapping
    public List<RewardRuleEntity> getAll() {
        return service.getAllRules();
    }

    @PutMapping("/{id}")
    public RewardRuleEntity update(@PathVariable Long id,
                                   @Valid @RequestBody RewardRuleEntity rule) {
        return service.updateRule(id, rule);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteRule(id);
        return "Reward rule deleted successfully";
    }
}

package com.example.demo.controller;

import com.example.demo.entity.RewardRuleEntity;
import com.example.demo.service.RewardRuleService;
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
    public RewardRuleEntity save(@RequestBody RewardRuleEntity entity) {
        return service.save(entity);
    }

    @GetMapping
    public List<RewardRuleEntity> getAll() {
        return service.getAll();
    }
}

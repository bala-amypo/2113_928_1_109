package com.example.demo.controller;

import com.example.demo.entity.RewardRuleEntity;
import com.example.demo.service.RewardRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reward-rules")
public class RewardRuleController {

private final RewardRuleService rewardRuleService;

public RewardRuleController(RewardRuleService rewardRuleService) {
this.rewardRuleService = rewardRuleService;
}

@PostMapping
public RewardRuleEntity save(@RequestBody RewardRuleEntity rule) {
return rewardRuleService.save(rule);
}

@GetMapping
public List<RewardRuleEntity> getAll() {
return rewardRuleService.getAll();
}
}

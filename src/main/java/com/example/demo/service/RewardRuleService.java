package com.example.demo.service;

import com.example.demo.entity.RewardRuleEntity;
import java.util.List;

public interface RewardRuleService {

    RewardRuleEntity createRule(RewardRuleEntity rule);
    RewardRuleEntity getRuleById(Long id);
    List<RewardRuleEntity> getAllRules();
    RewardRuleEntity updateRule(Long id, RewardRuleEntity rule);
    void deleteRule(Long id);
}

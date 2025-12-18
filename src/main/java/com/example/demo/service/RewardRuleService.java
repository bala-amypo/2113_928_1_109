package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.RewardRuleEntity;

public interface RewardRuleService {

    RewardRuleEntity createRule(RewardRuleEntity rule);

    List<RewardRuleEntity> getAllRules();

    RewardRuleEntity getRuleById(Long id);

    RewardRuleEntity updateRule(Long id, RewardRuleEntity rule);

    void deleteRule(Long id);
}

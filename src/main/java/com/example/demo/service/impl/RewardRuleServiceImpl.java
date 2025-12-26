package com.example.demo.service.impl;

import com.example.demo.entity.RewardRule;
import com.example.demo.repository.RewardRuleRepository;
import com.example.demo.service.RewardRuleService;

import java.util.List;

@Service 
public class RewardRuleServiceImpl implements RewardRuleService {

    private final RewardRuleRepository repo;

    public RewardRuleServiceImpl(RewardRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public RewardRule createRule(RewardRule rule) {
        return repo.save(rule);
    }

    @Override
    public List<RewardRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    @Override
    public List<RewardRule> getAllRules() {
        return repo.findAll();
    }
}

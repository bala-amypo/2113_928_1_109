
package com.example.demo.service.impl;

import com.example.demo.entity.RewardRuleEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RewardRuleRepository;
import com.example.demo.service.RewardRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardRuleServiceImpl implements RewardRuleService {

    private final RewardRuleRepository repository;

    public RewardRuleServiceImpl(RewardRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public RewardRuleEntity createRule(RewardRuleEntity rule) {
        return repository.save(rule);
    }

    @Override
    public RewardRuleEntity getRuleById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reward rule not found with id " + id));
    }

    @Override
    public List<RewardRuleEntity> getAllRules() {
        return repository.findAll();
    }

    @Override
    public RewardRuleEntity updateRule(Long id, RewardRuleEntity rule) {
        RewardRuleEntity existing = getRuleById(id);
        existing.setCategory(rule.getCategory());
        existing.setMultiplier(rule.getMultiplier());
        existing.setActive(rule.isActive());
        return repository.save(existing);
    }

    @Override
    public void deleteRule(Long id) {
        repository.delete(getRuleById(id));
    }
}
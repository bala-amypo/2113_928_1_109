package com.example.demo.service.impl;

import com.example.demo.entity.RewardRuleEntity;
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
    public RewardRuleEntity save(RewardRuleEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<RewardRuleEntity> getAll() {
        return repository.findAll();
    }
}

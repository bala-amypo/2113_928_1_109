package com.example.demo.service;

import com.example.demo.entity.RewardRuleEntity;
import java.util.List;

public interface RewardRuleService {
    RewardRuleEntity save(RewardRuleEntity entity);
    List<RewardRuleEntity> getAll();
}

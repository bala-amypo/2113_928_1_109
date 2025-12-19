package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.RewardRuleEntity;
import com.example.demo.repository.RewardRuleRepo;

@Service
public class RewardRuleServiceImpl implements RewardRuleService {

    private final RewardRuleRepo rewardRuleRepo;

    public RewardRuleServiceImpl(RewardRuleRepo rewardRuleRepo) {
        this.rewardRuleRepo = rewardRuleRepo;
    }

    @Override
    public RewardRuleEntity createRule(RewardRuleEntity rule) {
        return rewardRuleRepo.save(rule);
    }

    @Override
    public List<RewardRuleEntity> getAllRules() {
        return rewardRuleRepo.findAll();
    }

    @Override
    public RewardRuleEntity getRuleById(Long id) {
        return rewardRuleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reward rule not found"));
    }

    @Override
    public RewardRuleEntity updateRule(Long id, RewardRuleEntity updatedRule) {

        RewardRuleEntity rule = getRuleById(id);

        rule.setCreditCard(updatedRule.getCreditCard());
        rule.setCategory(updatedRule.getCategory());
        rule.setRewardMultiplier(updatedRule.getRewardMultiplier());
        rule.setActive(updatedRule.getActive());

        return rewardRuleRepo.save(rule);
    }

    @Override
    public void deleteRule(Long id) {
        rewardRuleRepo.deleteById(id);
    }
}

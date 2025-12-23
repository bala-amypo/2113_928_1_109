
package com.example.demo.service.impl;

import com.example.demo.entity.RecommendationEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RecommendationRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final RecommendationRepository repository;

    public RecommendationServiceImpl(RecommendationRepository repository) {
        this.repository = repository;
    }

    @Override
    public RecommendationEntity createRecommendation(RecommendationEntity recommendation) {
        return repository.save(recommendation);
    }

    @Override
    public RecommendationEntity getRecommendationById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recommendation not found with id " + id));
    }

    @Override
    public List<RecommendationEntity> getAllRecommendations() {
        return repository.findAll();
    }

    @Override
    public void deleteRecommendation(Long id) {
        repository.delete(getRecommendationById(id));
    }
}
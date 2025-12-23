package com.example.demo.service.impl;

import com.example.demo.entity.RecommendationEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RecommendationRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional   // Enables transaction management for all methods
public class RecommendationServiceImpl implements RecommendationService {

    private final RecommendationRepository repository;

    public RecommendationServiceImpl(RecommendationRepository repository) {
        this.repository = repository;
    }

    // Create a new recommendation (WRITE operation)
    @Override
    public RecommendationEntity createRecommendation(RecommendationEntity recommendation) {
        return repository.save(recommendation);
    }

    // Get recommendation by ID (READ operation)
    @Override
    @Transactional(readOnly = true)
    public RecommendationEntity getRecommendationById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Recommendation not found with id " + id));
    }

    // Get all recommendations (READ operation)
    @Override
    @Transactional(readOnly = true)
    public List<RecommendationEntity> getAllRecommendations() {
        return repository.findAll();
    }

    // Delete recommendation by ID (WRITE operation)
    @Override
    public void deleteRecommendation(Long id) {
        repository.delete(getRecommendationById(id));
    }
}

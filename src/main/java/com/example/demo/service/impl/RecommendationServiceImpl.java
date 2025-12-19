package com.example.demo.service.impl;

import com.example.demo.entity.RecommendationEntity;
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
    public RecommendationEntity save(RecommendationEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<RecommendationEntity> getAll() {
        return repository.findAll();
    }
}

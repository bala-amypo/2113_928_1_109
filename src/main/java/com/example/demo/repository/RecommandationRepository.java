package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.RecommendationEntity;
import com.example.demo.entity.UserProfileEntity;

public interface RecommendationRepository
        extends JpaRepository<RecommendationEntity, Long> {

    List<RecommendationEntity> findByUser(UserProfileEntity user);
}

package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "recommendations")
public class RecommendationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recommendationText;
    private double expectedReward;

    public RecommendationEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecommendationText() {
        return recommendationText;
    }

    public void setRecommendationText(String recommendationText) {
        this.recommendationText = recommendationText;
    }

    public double getExpectedReward() {
        return expectedReward;
    }

    public void setExpectedReward(double expectedReward) {
        this.expectedReward = expectedReward;
    }
}

package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "recommendation")
public class RecommendationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recommendedCard;

    private double expectedReward;

    /* Getters & Setters */

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }

    public String getRecommendedCard() {
        return recommendedCard;
    }
 
    public void setRecommendedCard(String recommendedCard) {
        this.recommendedCard = recommendedCard;
    }

    public double getExpectedReward() {
        return expectedReward;
    }
 
    public void setExpectedReward(double expectedReward) {
        this.expectedReward = expectedReward;
    }
}

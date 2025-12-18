package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RecommendationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private CreditCard recommendedCard;

    private Double rewardPoints;
    private LocalDateTime recommendedAt;

    @PrePersist
    public void onCreate() {
        this.recommendedAt = LocalDateTime.now();
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public CreditCard getRecommendedCard() { return recommendedCard; }
    public void setRecommendedCard(CreditCard recommendedCard) {
        this.recommendedCard = recommendedCard;
    }

    public Double getRewardPoints() { return rewardPoints; }
    public void setRewardPoints(Double rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public LocalDateTime getRecommendedAt() { return recommendedAt; }
}

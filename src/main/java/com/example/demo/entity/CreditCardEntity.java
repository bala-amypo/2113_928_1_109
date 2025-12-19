package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "credit_card")
public class CreditCardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String cardName;

    @NotBlank
    private String issuer;

    private String cardType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserProfileEntity user;

    @OneToMany(mappedBy = "creditCard", cascade = CascadeType.ALL)
    private List<RewardRuleEntity> rewardRules;

    /* Getters & Setters */

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCardName() { return cardName; }
    public void setCardName(String cardName) { this.cardName = cardName; }

    public String getIssuer() { return issuer; }
    public void setIssuer(String issuer) { this.issuer = issuer; }

    public String getCardType() { return cardType; }
    public void setCardType(String cardType) { this.cardType = cardType; }

    public UserProfileEntity getUser() { return user; }
    public void setUser(UserProfileEntity user) { this.user = user; }

    public List<RewardRuleEntity> getRewardRules() { return rewardRules; }
    public void setRewardRules(List<RewardRuleEntity> rewardRules) {
        this.rewardRules = rewardRules;
    }
}

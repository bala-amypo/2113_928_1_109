package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(
    name = "reward_rules",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"credit_card_id", "category_id"})
    }
)
public class RewardRuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Each rule belongs to a credit card
    @ManyToOne
    @JoinColumn(name = "credit_card_id", nullable = false)
    private CreditCard creditCard;

    // Each rule applies to a category
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // Multiplier or reward rate for this category
    private Double rewardMultiplier;

    // Whether this rule is active
    private Boolean active;

    /* ================= GETTERS & SETTERS ================= */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getRewardMultiplier() {
        return rewardMultiplier;
    }

    public void setRewardMultiplier(Double rewardMultiplier) {
        this.rewardMultiplier = rewardMultiplier;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

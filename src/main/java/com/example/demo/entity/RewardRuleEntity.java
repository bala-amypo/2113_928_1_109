package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "reward_rule")
public class RewardRuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String category;

    @Positive
    private double multiplier;

    private boolean active = true;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private CreditCardEntity creditCard;

    /* Getters & Setters */

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getMultiplier() { return multiplier; }
    public void setMultiplier(double multiplier) { this.multiplier = multiplier; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public CreditCardEntity getCreditCard() { return creditCard; }
    public void setCreditCard(CreditCardEntity creditCard) {
        this.creditCard = creditCard;
    }
}

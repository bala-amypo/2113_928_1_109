package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "reward_rule")
public class RewardRuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Category cannot be empty")
    private String category;

    @Positive(message = "Multiplier must be greater than zero")
    private double multiplier;

    private boolean active = true;

    /* Getters & Setters */

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }
 
    public void setCategory(String category) {
        this.category = category;
    }

    public double getMultiplier() {
        return multiplier;
    }
 
    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public boolean isActive() {
        return active;
    }
 
    public void setActive(boolean active) {
        this.active = active;
    }
}

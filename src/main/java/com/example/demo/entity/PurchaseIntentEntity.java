package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "purchase_intent")
public class PurchaseIntentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive(message = "Amount must be greater than zero")
    private double amount;

    @NotBlank(message = "Category cannot be empty")
    private String category;

    private String merchant;

    /* Getters & Setters */

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }
 
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }
 
    public void setCategory(String category) {
        this.category = category;
    }

    public String getMerchant() {
        return merchant;
    }
 
    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }
}

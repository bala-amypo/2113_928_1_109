package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "purchase_intents")
public class PurchaseIntentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String intentType;

    public PurchaseIntentEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntentType() {
        return intentType;
    }

    public void setIntentType(String intentType) {
        this.intentType = intentType;
    }
}

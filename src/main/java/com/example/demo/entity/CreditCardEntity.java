package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "credit_card")
public class CreditCardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Card name cannot be empty")
    private String cardName;

    @NotBlank(message = "Issuer cannot be empty")
    private String issuer;

    private String cardType;

    /* Getters & Setters */

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }
 
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getIssuer() {
        return issuer;
    }
 
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getCardType() {
        return cardType;
    }
 
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}

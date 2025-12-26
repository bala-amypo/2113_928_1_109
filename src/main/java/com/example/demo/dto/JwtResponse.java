package com.example.demo.dto;

public class JwtResponse {

    private String token;
    private Long userId;
    private String email;
    private String role;

    public JwtResponse() {
    }

    // ✅ Constructor used by AuthController
    public JwtResponse(Long userId, String email, String token) {
        this.userId = userId;
        this.email = email;
        this.token = token;
        this.role = null;
    }

    // ✅ Constructor used by tests
    public JwtResponse(Long userId, String email, String token, String role) {
        this.userId = userId;
        this.email = email;
        this.token = token;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    // Required by tests
    public JwtResponse getBody() {
        return this;
    }
}

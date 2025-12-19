package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserProfileEntity;
import com.example.demo.repository.UserProfileRepository;

@Service
public class UserProfileServiceImpl {

    private final UserProfileRepository userRepository;

    public UserProfileServiceImpl(UserProfileRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserProfileEntity createUser(UserProfileEntity user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(user);
    }

    public List<UserProfileEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserProfileEntity getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}

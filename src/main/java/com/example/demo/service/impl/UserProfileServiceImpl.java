package com.example.demo.service.impl;

import com.example.demo.entity.UserProfileEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional   // Enables transaction management for all methods
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository repository;

    public UserProfileServiceImpl(UserProfileRepository repository) {
        this.repository = repository;
    }

    // Create a new user profile (WRITE operation)
    @Override
    public UserProfileEntity createUser(UserProfileEntity user) {
        return repository.save(user);
    }

    // Get user profile by ID (READ operation)
    @Override
    @Transactional(readOnly = true)
    public UserProfileEntity getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id " + id));
    }

    // Get all user profiles (READ operation)
    @Override
    @Transactional(readOnly = true)
    public List<UserProfileEntity> getAllUsers() {
        return repository.findAll();
    }

    // Update user profile (WRITE operation)
    @Override
    public UserProfileEntity updateUser(Long id, UserProfileEntity user) {
        UserProfileEntity existing = getUserById(id);
        existing.setUsername(user.getUsername());
        existing.setEmail(user.getEmail());
        existing.setPassword(user.getPassword());
        existing.setActive(user.isActive());
        return repository.save(existing);
    }

    // Delete user profile by ID (WRITE operation)
    @Override
    public void deleteUser(Long id) {
        repository.delete(getUserById(id));
    }
}

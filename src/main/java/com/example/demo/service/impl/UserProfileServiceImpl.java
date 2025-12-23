
package com.example.demo.service.impl;

import com.example.demo.entity.UserProfileEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository repository;

    public UserProfileServiceImpl(UserProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserProfileEntity createUser(UserProfileEntity user) {
        return repository.save(user);
    }

    @Override
    public UserProfileEntity getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    @Override
    public List<UserProfileEntity> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public UserProfileEntity updateUser(Long id, UserProfileEntity user) {
        UserProfileEntity existing = getUserById(id);
        existing.setUsername(user.getUsername());
        existing.setEmail(user.getEmail());
        existing.setPassword(user.getPassword());
        existing.setActive(user.isActive());
        return repository.save(existing);
    }

    @Override
    public void deleteUser(Long id) {
        repository.delete(getUserById(id));
    }
}
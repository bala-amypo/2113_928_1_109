package com.example.demo.service.impl;

import com.example.demo.entity.UserProfileEntity;
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
    public UserProfileEntity save(UserProfileEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<UserProfileEntity> getAll() {
        return repository.findAll();
    }
}

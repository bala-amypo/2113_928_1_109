package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserProfileEntity;
import com.example.demo.repository.UserProfileRepository;

@RestController
@RequestMapping("/users")
public class UserProfileController {

    private final UserProfileRepository userRepo;

    public UserProfileController(UserProfileRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping
    public UserProfileEntity createUser(@RequestBody UserProfileEntity user) {
        return userRepo.save(user);
    }

    @GetMapping
    public List<UserProfileEntity> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public UserProfileEntity getUserById(@PathVariable Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}

package com.example.demo.controller;

import com.example.demo.entity.UserProfileEntity;
import com.example.demo.service.UserProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-profiles")
public class UserProfileController {

    private final UserProfileService service;

    public UserProfileController(UserProfileService service) {
        this.service = service;
    }

    @PostMapping
    public UserProfileEntity save(@RequestBody UserProfileEntity entity) {
        return service.save(entity);
    }

    @GetMapping
    public List<UserProfileEntity> getAll() {
        return service.getAll();
    }
}

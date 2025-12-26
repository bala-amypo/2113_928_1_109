package com.example.demo.controller;

import com.example.demo.entity.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    private final UserProfileService userService;

    public UserProfileController(UserProfileService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserProfile createUser(@RequestBody UserProfile user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public UserProfile getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserProfile> getAllUsers() {
        return userService.getAllUsers();
    }
}

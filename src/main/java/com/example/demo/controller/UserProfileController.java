package com.example.demo.controller;

import com.example.demo.entity.UserProfileEntity;
import com.example.demo.service.UserProfileService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserProfileController {

    private final UserProfileService service;

    public UserProfileController(UserProfileService service) {
        this.service = service;
    }

    @PostMapping
    public UserProfileEntity create(@Valid @RequestBody UserProfileEntity user) {
        return service.createUser(user);
    }

    @GetMapping("/{id}")
    public UserProfileEntity getById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @GetMapping
    public List<UserProfileEntity> getAll() {
        return service.getAllUsers();
    }

    @PutMapping("/{id}")
    public UserProfileEntity update(@PathVariable Long id,
                                    @Valid @RequestBody UserProfileEntity user) {
        return service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted successfully";
    }
}

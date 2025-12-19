package com.example.demo.controller;

import com.example.demo.entity.UserProfileEntity;
import com.example.demo.service.UserProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserProfileController {

private final UserProfileService userProfileService;

public UserProfileController(UserProfileService userProfileService) {
this.userProfileService = userProfileService;
}

@PostMapping
public UserProfileEntity save(@RequestBody UserProfileEntity user) {
return userProfileService.save(user);
}

@GetMapping
public List<UserProfileEntity> getAll() {
return userProfileService.getAll();
}
}

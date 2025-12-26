package com.example.demo.controller;

import com.example.demo.service.UserProfileService;

public class UserProfileController {

    private final UserProfileService userService;

    public UserProfileController(UserProfileService userService) {
        this.userService = userService;
    }
}

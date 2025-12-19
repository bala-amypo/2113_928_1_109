package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.UserProfileEntity;

public interface UserProfileService {

    UserProfileEntity createUser(UserProfileEntity user);

    List<UserProfileEntity> getAllUsers();

    UserProfileEntity getUserById(Long id);
}

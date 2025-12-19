package com.example.demo.service;

import com.example.demo.entity.UserProfileEntity;
import java.util.List;

public interface UserProfileService {

    UserProfileEntity createUser(UserProfileEntity user);
    UserProfileEntity getUserById(Long id);
    List<UserProfileEntity> getAllUsers();
    UserProfileEntity updateUser(Long id, UserProfileEntity user);
    void deleteUser(Long id);
}

package com.example.demo.service;

import com.example.demo.entity.UserProfileEntity;
import java.util.List;

public interface UserProfileService {
    UserProfileEntity save(UserProfileEntity entity);
    List<UserProfileEntity> getAll();
}

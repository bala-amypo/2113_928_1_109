package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.PurchaseIntentity;
import com.example.demo.entity.UserProfileEntity;

public interface PurchaseIntentityRepository
        extends JpaRepository<PurchaseIntentity, Long> {

    List<PurchaseIntentity> findByUser(UserProfileEntity user);
}

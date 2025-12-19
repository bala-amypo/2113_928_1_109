package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.RewardRuleEntity;
import com.example.demo.entity.CreditCard;
import com.example.demo.entity.Category;

public interface RewardRuleRepository
        extends JpaRepository<RewardRuleEntity, Long> {

    List<RewardRuleEntity> findByCreditCard(CreditCard creditCard);

    boolean existsByCreditCardAndCategory(
            CreditCard creditCard,
            Category category
    );
}

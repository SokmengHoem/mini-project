package com.example.mini_pos.repositories;

import com.example.mini_pos.model.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    Optional<ExchangeRate> findByIdAndIsDeletedFalse(Long id);
    List<ExchangeRate> findByIsDeletedFalseOrderByIdDesc();
}

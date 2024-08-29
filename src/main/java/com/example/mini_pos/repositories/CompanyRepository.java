package com.example.mini_pos.repositories;

import com.example.mini_pos.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByIdAndIsDeletedFalse(Long id);
    List<Company> findByIsDeletedFalseOrderByIdDesc();
}

package com.example.mini_pos.repositories;

import com.example.mini_pos.model.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Optional<Supplier> findByIdAndIsDeletedFalse(Long id);
    List<Supplier> findByIsDeletedFalseOrderByIdDesc();
}

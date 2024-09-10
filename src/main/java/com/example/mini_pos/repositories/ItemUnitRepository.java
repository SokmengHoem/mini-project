package com.example.mini_pos.repositories;

import com.example.mini_pos.model.entity.ItemUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemUnitRepository extends JpaRepository<ItemUnit, Long> {
    Optional<ItemUnit> findByIdAndIsDeletedFalse(Long id);

    List<ItemUnit> findByIsDeletedFalseOrderByIdDesc();

    // Add this method to check if a non-deleted parent exists by id
    boolean existsByIdAndIsDeletedFalse(Long id);
}

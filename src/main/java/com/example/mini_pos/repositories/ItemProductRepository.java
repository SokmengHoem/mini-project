package com.example.mini_pos.repositories;

import com.example.mini_pos.model.entity.ItemProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemProductRepository extends JpaRepository<ItemProduct, Long> {
    Optional<ItemProduct> findByIdAndIsDeletedFalse(Long id);
    List<ItemProduct> findByIsDeletedFalseOrderByIdDesc();

}

package com.example.mini_pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mini_pos.model.entity.Brand;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{
	//for soft delete
    Optional<Brand> findByIdAndIsDeletedFalse(Long id);
    List<Brand> findByIsDeletedFalseOrderByIdDesc();
}

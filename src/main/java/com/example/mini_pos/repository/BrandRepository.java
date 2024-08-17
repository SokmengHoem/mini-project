package com.example.mini_pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mini_pos.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{
	
}

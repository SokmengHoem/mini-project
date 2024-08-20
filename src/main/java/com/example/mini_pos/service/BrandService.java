package com.example.mini_pos.service;

import java.util.List;

import com.example.mini_pos.model.entity.Brand;
import com.example.mini_pos.model.response.BrandResponse;

public interface BrandService {
	Brand saveData(Brand branch);
    
	Brand getById(Long id);
	
	Brand update(Long id, Brand update);
	
	List<BrandResponse> listAll();
	
	Brand deleteById(Long id);
}

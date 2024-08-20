package com.example.mini_pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mini_pos.model.entity.Brand;
import com.example.mini_pos.mapper.BrandMapper;
import com.example.mini_pos.model.request.BrandRequest;
import com.example.mini_pos.model.response.BrandResponse;
import com.example.mini_pos.service.BrandService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("brands")
public class BrandController {
	
	@Autowired
	private BrandService branchService;
	
	@Autowired
	private BrandMapper brandMapper;
	
	@PostMapping
	public ResponseEntity<BrandResponse> saveData(@Valid @RequestBody BrandRequest dto){
		Brand branch = brandMapper.toEntity(dto);
		Brand saveData = branchService.saveData(branch);
		
		BrandResponse response = brandMapper.toDTO(saveData);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<BrandResponse> getByIdEntity (@PathVariable Long id) {
		Brand getData = branchService.getById(id);
		
		BrandResponse response = brandMapper.toDTO(getData);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<BrandResponse> update( @PathVariable Long id, @Valid @RequestBody BrandRequest request){
		Brand brand = brandMapper.toEntity(request);
		Brand update = branchService.update(id, brand);
		
		BrandResponse response = brandMapper.toDTO(update);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public ResponseEntity<List<BrandResponse>> getAllEntity() {
		List<BrandResponse> responses = branchService.listAll();
		return ResponseEntity.ok(responses);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Brand deleteById = branchService.deleteById(id);
		BrandResponse response = brandMapper.toDTO(deleteById);
		return ResponseEntity.ok(response);
	}
}

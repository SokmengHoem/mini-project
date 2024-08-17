package com.example.mini_pos.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mini_pos.entity.Brand;
import com.example.mini_pos.execption.ResourceNotFoundException;
import com.example.mini_pos.mapper.BrandMapper;
import com.example.mini_pos.repository.BrandRepository;
import com.example.mini_pos.response.BrandResponse;
import com.example.mini_pos.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{
	
	@Autowired
	private BrandRepository branchRepository;
	
	@Autowired
	private BrandMapper brandMapper;
	
	@Override
	public Brand saveData(Brand branch) {
		// TODO Auto-generated method stub
		return branchRepository.save(branch);
	}

	@Override
	public Brand getById(Long id) {
		return branchRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Brand", id));
	}

	@Override
	public Brand update(Long id, Brand update) {
	    Brand dataUpdate = getById(id);
	    dataUpdate.setName(update.getName()); // This should work now
	    return branchRepository.save(dataUpdate);
	}

	@Override
	public List<BrandResponse> listAll() {
		// TODO Auto-generated method stub
		return branchRepository.findAll().stream()
				.map(brandMapper::toDTO)
				.collect(Collectors.toList());
	}

	@Override
	public Brand deleteById(Long id) {
		// TODO Auto-generated method stub
		Brand byIdBrand =  getById(id);
		 branchRepository.delete(byIdBrand);
		 return byIdBrand;
	}
	
}

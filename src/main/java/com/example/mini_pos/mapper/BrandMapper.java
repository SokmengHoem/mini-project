package com.example.mini_pos.mapper;

import org.mapstruct.Mapper;

import com.example.mini_pos.model.entity.Brand;
import com.example.mini_pos.model.request.BrandRequest;
import com.example.mini_pos.model.response.BrandResponse;



@Mapper(componentModel = "spring")
public interface BrandMapper {
  Brand toEntity(BrandRequest request);
  
  BrandResponse toDTO(Brand entity);
}

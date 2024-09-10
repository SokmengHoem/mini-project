package com.example.mini_pos.mapper;

import org.mapstruct.Mapper;

import com.example.mini_pos.model.entity.Brand;
import com.example.mini_pos.model.request.BrandRequest;
import com.example.mini_pos.model.response.BrandResponse;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BrandMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "deleted", ignore = true)
  Brand toEntity(BrandRequest request);
  
  BrandResponse toDTO(Brand entity);
}

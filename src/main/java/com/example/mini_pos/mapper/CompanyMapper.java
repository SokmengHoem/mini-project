package com.example.mini_pos.mapper;

import com.example.mini_pos.model.entity.Company;
import com.example.mini_pos.model.request.CompanyRequest;
import com.example.mini_pos.model.response.CompanyResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    Company toEntity(CompanyRequest request);

    CompanyResponse toDTO(Company entity);
}

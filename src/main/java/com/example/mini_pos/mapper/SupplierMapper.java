package com.example.mini_pos.mapper;

import com.example.mini_pos.model.entity.Supplier;
import com.example.mini_pos.model.request.SupplierRequest;
import com.example.mini_pos.model.response.SupplierResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    Supplier toEntity(SupplierRequest request);
    SupplierResponse toDTO(Supplier entity);
}

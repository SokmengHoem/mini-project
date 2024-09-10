package com.example.mini_pos.mapper;

import com.example.mini_pos.model.entity.Customer;
import com.example.mini_pos.model.request.CustomerRequest;
import com.example.mini_pos.model.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    Customer toEntity(CustomerRequest request);
    CustomerResponse toDTO(Customer entity);
}

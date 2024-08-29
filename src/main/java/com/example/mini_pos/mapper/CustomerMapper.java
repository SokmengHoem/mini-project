package com.example.mini_pos.mapper;

import com.example.mini_pos.model.entity.Customer;
import com.example.mini_pos.model.request.CustomerRequest;
import com.example.mini_pos.model.response.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toEntity(CustomerRequest request);
    CustomerResponse toDTO(Customer entity);
}

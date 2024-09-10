package com.example.mini_pos.mapper;

import com.example.mini_pos.model.entity.ExchangeRate;
import com.example.mini_pos.model.request.ExchangeRateRequest;
import com.example.mini_pos.model.response.ExchangeRateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExchangeRateMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    ExchangeRate toEntity(ExchangeRateRequest request);
    ExchangeRateResponse toDTO(ExchangeRate entity);
}

package com.example.mini_pos.mapper;

import com.example.mini_pos.model.entity.ExchangeRate;
import com.example.mini_pos.model.request.ExchangeRateRequest;
import com.example.mini_pos.model.response.ExchangeRateResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExchangeRateMapper {
    ExchangeRate toEntity(ExchangeRateRequest request);
    ExchangeRateResponse toDTO(ExchangeRate entity);
}

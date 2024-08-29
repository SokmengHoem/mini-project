package com.example.mini_pos.service;

import com.example.mini_pos.model.entity.ExchangeRate;
import com.example.mini_pos.model.response.ExchangeRateResponse;

import java.util.List;

public interface ExchangeRateService {
    ExchangeRate created(ExchangeRate request);
    ExchangeRate getById(Long id);
    ExchangeRate updated(Long id, ExchangeRate update);
    List<ExchangeRateResponse> listAll();
    ExchangeRate deleteById(Long id);
}

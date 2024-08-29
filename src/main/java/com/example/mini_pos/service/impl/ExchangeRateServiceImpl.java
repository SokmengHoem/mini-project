package com.example.mini_pos.service.impl;

import com.example.mini_pos.execption.ResourceNotFoundException;
import com.example.mini_pos.mapper.ExchangeRateMapper;
import com.example.mini_pos.model.entity.ExchangeRate;
import com.example.mini_pos.model.response.ExchangeRateResponse;
import com.example.mini_pos.repositories.ExchangeRateRepository;
import com.example.mini_pos.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Autowired
    private ExchangeRateMapper exchangeRateMapper;

    @Override
    public ExchangeRate created(ExchangeRate request) {
        return exchangeRateRepository.save(request);
    }

    @Override
    public ExchangeRate getById(Long id) {
        return exchangeRateRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("ExchangeRate", id));
    }

    @Override
    public ExchangeRate updated(Long id, ExchangeRate update) {
        ExchangeRate exchangeRate = getById(id);
        exchangeRate.setExchangeRate(update.getExchangeRate());
        return exchangeRateRepository.save(exchangeRate);
    }

    @Override
    public List<ExchangeRateResponse> listAll() {
        return exchangeRateRepository.findByIsDeletedFalseOrderByIdDesc().stream()
                .map(exchangeRateMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ExchangeRate deleteById(Long id) {
        ExchangeRate exchangeRate = getById(id);
        exchangeRate.setDeleted(true);
        return exchangeRateRepository.save(exchangeRate);
    }
}

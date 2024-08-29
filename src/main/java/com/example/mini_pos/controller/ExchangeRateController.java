package com.example.mini_pos.controller;

import com.example.mini_pos.mapper.ExchangeRateMapper;
import com.example.mini_pos.model.entity.ExchangeRate;
import com.example.mini_pos.model.request.ExchangeRateRequest;
import com.example.mini_pos.model.response.ExchangeRateResponse;
import com.example.mini_pos.service.ExchangeRateService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("exchangeRate")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @Autowired
    private ExchangeRateMapper exchangeRateMapper;

    @PostMapping
    public ResponseEntity<ExchangeRateResponse> createCustomer (@Valid  @RequestBody ExchangeRateRequest request){
        ExchangeRate exchangeRate = exchangeRateMapper.toEntity(request);
        ExchangeRate newExchange = exchangeRateService.created(exchangeRate);

        ExchangeRateResponse response = exchangeRateMapper.toDTO(newExchange);
        return  ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<ExchangeRateResponse> getByIdExchangeRate(@PathVariable Long id){
        ExchangeRate exchangeRate = exchangeRateService.getById(id);
        ExchangeRateResponse response = exchangeRateMapper.toDTO(exchangeRate);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<ExchangeRateResponse> updatedExchangeRate(@PathVariable Long id, ExchangeRateRequest request){
        ExchangeRate exchangeRate = exchangeRateMapper.toEntity(request);
        ExchangeRate update = exchangeRateService.updated(id, exchangeRate);
        ExchangeRateResponse response = exchangeRateMapper.toDTO(update);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ExchangeRateResponse>> getAllExchangeRate(){
        List<ExchangeRateResponse> lists = exchangeRateService.listAll();
        return ResponseEntity.ok(lists);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExchangeRate(@PathVariable Long id){
         exchangeRateService.deleteById(id);
        return ResponseEntity.ok("Deleted Success!!!");
    }
}

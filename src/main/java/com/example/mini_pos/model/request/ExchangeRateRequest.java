package com.example.mini_pos.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ExchangeRateRequest {

    @NotNull(message = "Exchange rate is required.")
    @Positive(message = "Exchange rate must be a positive number.")
    private Double exchangeRate;

    private boolean isDelete;
}

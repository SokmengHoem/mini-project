package com.example.mini_pos.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "exchangeRates")
public class ExchangRate {
    private Double exchangeRate;

    private boolean isDelete;
}

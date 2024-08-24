package com.example.mini_pos.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerLocalName;

    private String customerEngName;

    private String customerEmail;

    private String customerPhone;

    private String customerAddress;

    private boolean isDeleted;
}

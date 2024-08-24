package com.example.mini_pos.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String supplierLocalName;

    private String supplierEngName;

    private String supplierEmail;

    private String supplierPhone;

    private String supplierAddress;

    private String vatNumber;

    private boolean isDeleted;
}

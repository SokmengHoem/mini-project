package com.example.mini_pos.model.response;

import lombok.Data;

@Data
public class SupplierResponse {
    private Long id;

    private String supplierLocalName;

    private String supplierEngName;

    private String supplierEmail;

    private String supplierPhone;

    private String supplierAddress;

    private String vatNumber;
}

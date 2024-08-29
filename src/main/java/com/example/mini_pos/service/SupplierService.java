package com.example.mini_pos.service;

import com.example.mini_pos.model.entity.Supplier;
import com.example.mini_pos.model.response.SupplierResponse;

import java.util.List;

public interface SupplierService {
    Supplier create(Supplier request);
    Supplier getById(Long id);
    Supplier update(Long id, Supplier update);
    List<SupplierResponse> listAll();
    Supplier deleteById(Long id);
}

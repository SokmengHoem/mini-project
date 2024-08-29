package com.example.mini_pos.service;

import com.example.mini_pos.model.entity.Company;
import com.example.mini_pos.model.response.CompanyResponse;

import java.util.List;

public interface CompanyService {
    Company saveData(Company company);
    Company getById(Long id);
    Company updated(Long id, Company update);
    List<CompanyResponse> getAll();
    Company deleteById(Long id);
}

package com.example.mini_pos.service.impl;

import com.example.mini_pos.execption.ResourceNotFoundException;
import com.example.mini_pos.mapper.CompanyMapper;
import com.example.mini_pos.model.entity.Company;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import com.example.mini_pos.model.response.CompanyResponse;
import com.example.mini_pos.repositories.CompanyRepository;
import com.example.mini_pos.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public Company saveData(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company getById(Long id) {
        return companyRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company", id));
    }

    @Override
    public Company updated(Long id, Company update) {
        Company companyUpdate = getById(id);

        for (Field field : Company.class.getDeclaredFields()) {
            field.setAccessible(true); // allow access to private fields
            try {
                Object newValue = field.get(update);
                if (newValue != null) {
                    field.set(companyUpdate, newValue);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Failed to update field: " + field.getName(), e);
            }
        }
        return companyRepository.save(companyUpdate);
    }

    @Override
    public List<CompanyResponse> getAll() {
        return companyRepository.findByIsDeletedFalseOrderByIdDesc().stream()
                .map(companyMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Company deleteById(Long id) {
        Company company = getById(id);
        company.setDeleted(true);
        return companyRepository.save(company);
    }

}

package com.example.mini_pos.service.impl;

import com.example.mini_pos.execption.ResourceNotFoundException;
import com.example.mini_pos.mapper.SupplierMapper;
import com.example.mini_pos.model.entity.Supplier;
import com.example.mini_pos.model.response.SupplierResponse;
import com.example.mini_pos.repositories.SupplierRepository;
import com.example.mini_pos.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public Supplier create(Supplier request) {
        return supplierRepository.save(request);
    }

    @Override
    public Supplier getById(Long id) {
        return supplierRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("Supplier",id));
    }

    @Override
    public Supplier update(Long id, Supplier update) {
        Supplier supplierUpdate = getById(id);

        for (Field field: Supplier.class.getDeclaredFields()){
            field.setAccessible(true);
            try {
                Object newValue = field.get(update);
                if(newValue != null){
                    field.set(supplierUpdate, newValue);
                }
            }catch (IllegalAccessException e) {
                throw new RuntimeException("Failed to update field: " + field.getName(), e);
            }
        }
        return null;
    }

    @Override
    public List<SupplierResponse> listAll() {
        return supplierRepository.findByIsDeletedFalseOrderByIdDesc().stream()
                .map(supplierMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Supplier deleteById(Long id) {
        Supplier supplier = getById(id);
        supplier.setDeleted(true);
        return supplierRepository.save(supplier);
    }
}

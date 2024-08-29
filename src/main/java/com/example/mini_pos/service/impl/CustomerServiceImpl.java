package com.example.mini_pos.service.impl;

import com.example.mini_pos.execption.ResourceNotFoundException;
import com.example.mini_pos.mapper.CustomerMapper;
import com.example.mini_pos.model.entity.Customer;
import com.example.mini_pos.model.response.CustomerResponse;
import com.example.mini_pos.repositories.CustomerRepository;
import com.example.mini_pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("Customer", id));
    }

    @Override
    public Customer updated(Long id, Customer update) {
        Customer customerUpdate = getById(id);

        for (Field field : Customer.class.getDeclaredFields()){
            field.setAccessible(true);
            try{
                Object newValue = field.get(update);
                if(newValue != null){
                    field.set(customerUpdate, newValue);
                }
            }catch (IllegalAccessException e) {
                throw new RuntimeException("Failed to update field: " + field.getName(), e);
            }
        }
        return customerRepository.save(customerUpdate);
    }

    @Override
    public List<CustomerResponse> listAll() {
        return customerRepository.findByIsDeletedFalseOrderByIdDesc().stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Customer deleted(Long id) {
        Customer customer = getById(id);
        customer.setDeleted(true);
        return customerRepository.save(customer);
    }
}

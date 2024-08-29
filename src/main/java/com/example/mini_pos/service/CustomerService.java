package com.example.mini_pos.service;

import com.example.mini_pos.model.entity.Customer;
import com.example.mini_pos.model.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    Customer create(Customer customer);
    Customer getById(Long id);
    Customer updated(Long id, Customer update);
    List<CustomerResponse> listAll ();
    Customer deleted(Long id);
}

package com.example.mini_pos.controller;

import com.example.mini_pos.mapper.CustomerMapper;
import com.example.mini_pos.model.entity.Customer;
import com.example.mini_pos.model.request.CustomerRequest;
import com.example.mini_pos.model.response.CustomerResponse;
import com.example.mini_pos.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody CustomerRequest request){
        Customer customer = customerMapper.toEntity(request);
        Customer customerInfo = customerService.create(customer);

        CustomerResponse response = customerMapper.toDTO(customer);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerResponse> getByIdCustomer(@PathVariable Long id){
        Customer customer = customerService.getById(id);
        CustomerResponse response = customerMapper.toDTO(customer);
        return  ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<CustomerResponse> updatedCustomer(@PathVariable Long id, @RequestBody CustomerRequest request){
        Customer customer = customerMapper.toEntity(request);
        Customer update = customerService.updated(id, customer);

        CustomerResponse response = customerMapper.toDTO(update);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> listAllCustomer() {
        List<CustomerResponse> customers = customerService.listAll();
        return ResponseEntity.ok(customers);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CustomerResponse> deletedCustomer(@PathVariable Long id){
        Customer customer = customerService.deleted(id);

        CustomerResponse response = customerMapper.toDTO(customer);
        return ResponseEntity.ok(response);
    }

}

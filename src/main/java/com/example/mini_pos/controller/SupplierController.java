package com.example.mini_pos.controller;

import com.example.mini_pos.mapper.SupplierMapper;
import com.example.mini_pos.model.entity.Supplier;
import com.example.mini_pos.model.request.SupplierRequest;
import com.example.mini_pos.model.response.SupplierResponse;
import com.example.mini_pos.service.SupplierService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private SupplierMapper supplierMapper;

    @PostMapping
    public ResponseEntity<SupplierResponse> createSupplier(@RequestBody SupplierRequest request){
        Supplier supplier = supplierMapper.toEntity(request);
        Supplier newData = supplierService.create(supplier);

        SupplierResponse response = supplierMapper.toDTO(newData);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<SupplierResponse> getByIdSupplier(@PathVariable Long id){
        Supplier supplier = supplierService.getById(id);

        SupplierResponse response = supplierMapper.toDTO(supplier);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<SupplierResponse> updateSupplier(@PathVariable Long id, @RequestBody SupplierRequest request){
        Supplier supplier = supplierMapper.toEntity(request);
        Supplier newData = supplierService.update(id, supplier);

        SupplierResponse response = supplierMapper.toDTO(newData);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<SupplierResponse>> listAllSupplier(){
        List<SupplierResponse> lists = supplierService.listAll();
        return ResponseEntity.ok(lists);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String > deleteSupplier(@PathVariable Long id) {
        supplierService.deleteById(id);
        return ResponseEntity.ok("Delete Success");
    }

}

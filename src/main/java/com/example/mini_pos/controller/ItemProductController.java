package com.example.mini_pos.controller;

import com.example.mini_pos.mapper.ItemProductMapper;
import com.example.mini_pos.mapper.ItemUnitMapper;
import com.example.mini_pos.model.entity.ItemProduct;
import com.example.mini_pos.model.request.ItemProductRequest;
import com.example.mini_pos.model.response.ItemProductResponse;
import com.example.mini_pos.service.ItemProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ItemProductController {

    private final ItemProductService itemProductService;
    private final ItemProductMapper itemProductMapper;

    @PostMapping
    public ResponseEntity<ItemProductResponse> createProduct(@Valid @RequestBody ItemProductRequest request) {
        ItemProduct product = itemProductMapper.toEntity(request);
        ItemProduct infoProduct = itemProductService.create(product);
        ItemProductResponse response = itemProductMapper.toDTO(infoProduct);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<ItemProductResponse> getByIdProduct(@PathVariable Long id) {
        ItemProduct product = itemProductService.getById(id);
        ItemProductResponse response = itemProductMapper.toDTO(product);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<ItemProductResponse> updateById(@PathVariable Long id , @RequestBody ItemProductRequest request){
        ItemProduct product = itemProductMapper.toEntity(request);
        ItemProduct productUpdated = itemProductService.update(id, product);
        ItemProductResponse response = itemProductMapper.toDTO(productUpdated);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ItemProductResponse>> listAllProduct() {
        List<ItemProductResponse> responses = itemProductService.listAll();
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteByIdProduct(@PathVariable Long id){
        itemProductService.deleteById(id);
        return ResponseEntity.ok("Delete Success!!!");
    }
}

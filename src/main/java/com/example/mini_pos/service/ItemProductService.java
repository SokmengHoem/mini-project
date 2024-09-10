package com.example.mini_pos.service;

import com.example.mini_pos.model.entity.ItemProduct;
import com.example.mini_pos.model.response.ItemProductResponse;

import java.util.List;

public interface ItemProductService {

    ItemProduct create(ItemProduct product);
    ItemProduct getById(Long id);
    ItemProduct update(Long id, ItemProduct product);
    List<ItemProductResponse> listAll();
    ItemProduct deleteById(Long id);
}

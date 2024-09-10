package com.example.mini_pos.service;

import com.example.mini_pos.model.entity.ItemUnit;
import com.example.mini_pos.model.response.ItemUnitResponse;

import java.util.List;

public interface ItemUnitService {
    ItemUnit create(ItemUnit itemUnit);
    ItemUnit getById(Long id);
    ItemUnit update(Long id, ItemUnit itemUnit);
    List<ItemUnitResponse> listAll();
    ItemUnit deleteById(Long id);
}

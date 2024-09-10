package com.example.mini_pos.service.impl;

import com.example.mini_pos.execption.ResourceNotFoundException;
import com.example.mini_pos.mapper.ItemProductMapper;
import com.example.mini_pos.model.entity.ItemProduct;
import com.example.mini_pos.model.response.ItemProductResponse;
import com.example.mini_pos.repositories.ItemProductRepository;
import com.example.mini_pos.repositories.ItemUnitRepository;
import com.example.mini_pos.service.ItemProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemProductServiceImpl implements ItemProductService {

    private final ItemProductRepository itemProductRepository;
    private final ItemProductMapper itemProductMapper;

    @Override
    public ItemProduct create(ItemProduct product) {
        return itemProductRepository.save(product);
    }

    @Override
    public ItemProduct getById(Long id) {
        return itemProductRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("Product", id));
    }

    @Override
    public ItemProduct update(Long id, ItemProduct product) {
        ItemProduct existingProduct = getById(id);

        // Use reflection to update fields
        Field[] fields = product.getClass().getDeclaredFields();
        for (Field field: fields) {
            field.setAccessible(true);
            try {
                Object updateValue = field.get(product);
                if(updateValue != null) {
                    field.set(existingProduct, updateValue);
                }
            }catch (IllegalAccessException e){
                throw new RuntimeException("Failed to update field: " + field.getName(), e);
            }
        }
        return itemProductRepository.save(existingProduct);
    }

    @Override
    public List<ItemProductResponse> listAll() {
        return itemProductRepository.findByIsDeletedFalseOrderByIdDesc().stream().map(itemProductMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ItemProduct deleteById(Long id) {
        ItemProduct existingProduct = getById(id);
        existingProduct.setDeleted(true);
        return itemProductRepository.save(existingProduct);
    }
}

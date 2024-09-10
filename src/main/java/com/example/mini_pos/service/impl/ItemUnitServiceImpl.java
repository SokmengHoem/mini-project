package com.example.mini_pos.service.impl;

import com.example.mini_pos.execption.ResourceNotFoundException;
import com.example.mini_pos.mapper.ItemUnitMapper;
import com.example.mini_pos.model.entity.ItemUnit;
import com.example.mini_pos.model.response.ItemUnitResponse;
import com.example.mini_pos.repositories.ItemUnitRepository;
import com.example.mini_pos.service.ItemUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemUnitServiceImpl implements ItemUnitService {

    private final ItemUnitRepository itemUnitRepository;
    private final ItemUnitMapper itemUnitMapper;

    @Override
    public ItemUnit create(ItemUnit itemUnit) {
        ItemUnit parentEntityItemUnit = new ItemUnit();
        parentEntityItemUnit.setItemUnitName(itemUnit.getItemUnitName());
        parentEntityItemUnit.setItemUnitCode(itemUnit.getItemUnitCode());
        parentEntityItemUnit.setOperator(itemUnit.getOperator());
        parentEntityItemUnit.setOperationValue(itemUnit.getOperationValue());

        // Check if parent exists
        if(itemUnit.getParent() != null && itemUnit.getParent().getId() != null) {
            boolean parentExists = itemUnitRepository.existsByIdAndIsDeletedFalse(itemUnit.getParent().getId());
            if(!parentExists) {
                throw new ResourceNotFoundException("ItemUnit", itemUnit.getParent().getId());
            }
            parentEntityItemUnit.setParent(itemUnit.getParent());// Set the valid parent
        }

        return itemUnitRepository.save(parentEntityItemUnit);
    }

    @Override
    public ItemUnit getById(Long id) {
        return itemUnitRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("itemUnit", id));
    }

    @Override
    public ItemUnit update(Long id, ItemUnit itemUnit) {
        ItemUnit existingItemUnit = getById(id);

        // Update the existing ItemUnit's fields if the new values are not null
        if(itemUnit.getItemUnitName() != null){
            existingItemUnit.setItemUnitName(itemUnit.getItemUnitName());
        }
        if(itemUnit.getItemUnitCode() != null){
            existingItemUnit.setItemUnitCode(itemUnit.getItemUnitCode());
        }
        if(itemUnit.getOperator() != null) {
            existingItemUnit.setOperator(itemUnit.getOperator());
        }
        if(itemUnit.getOperationValue() != null) {
            existingItemUnit.setOperationValue(itemUnit.getOperationValue());
        }
        // Check if the updated parent exists and is not deleted
        if(itemUnit.getParent() != null && itemUnit.getParent().getId() != null){
            boolean parentExists = itemUnitRepository.existsByIdAndIsDeletedFalse(itemUnit.getParent().getId());
            if(!parentExists) {
                throw new ResourceNotFoundException("Parent ItemUnit", itemUnit.getParent().getId());
            }
            existingItemUnit.setParent((itemUnit.getParent()));
        } else if (itemUnit.getParent() == null) {
            existingItemUnit.setParent(null);
        }

        return itemUnitRepository.save(existingItemUnit);
    }

    @Override
    public List<ItemUnitResponse> listAll() {
        return itemUnitRepository.findByIsDeletedFalseOrderByIdDesc().stream().map(itemUnitMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ItemUnit deleteById(Long id) {
        ItemUnit itemUnit = getById(id);
        itemUnit.setDeleted(true);
        return itemUnitRepository.save(itemUnit);
    }
}

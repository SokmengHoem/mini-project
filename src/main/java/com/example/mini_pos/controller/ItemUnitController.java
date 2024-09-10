package com.example.mini_pos.controller;

import com.example.mini_pos.mapper.ItemUnitMapper;
import com.example.mini_pos.model.entity.ItemUnit;
import com.example.mini_pos.model.request.ItemUnitRequest;
import com.example.mini_pos.model.response.ItemUnitResponse;
import com.example.mini_pos.service.ItemUnitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("itemUnits")
@RequiredArgsConstructor
public class ItemUnitController {

    private final ItemUnitService itemUnitService;
    private final ItemUnitMapper itemUnitMapper;

    @PostMapping
    public ResponseEntity<ItemUnitResponse> createItemUnit(@Valid @RequestBody ItemUnitRequest request) {
        ItemUnit itemUnit = itemUnitMapper.toEntity(request);
        ItemUnit createUnit = itemUnitService.create(itemUnit);
        ItemUnitResponse response = itemUnitMapper.toDTO(createUnit);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<ItemUnitResponse> getByIdItemUnit(@PathVariable Long id){
        ItemUnit itemUnit = itemUnitService.getById(id);
        ItemUnitResponse response = itemUnitMapper.toDTO(itemUnit);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<ItemUnitResponse> updateByIdItemUnit(@PathVariable Long id, @RequestBody ItemUnitRequest request){
        ItemUnit unit = itemUnitMapper.toEntity(request);
        ItemUnit unitUpdate = itemUnitService.update(id, unit);
        ItemUnitResponse response = itemUnitMapper.toDTO(unitUpdate);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ItemUnitResponse>> getAllItemUnit() {
        List<ItemUnitResponse> lists = itemUnitService.listAll();
        return ResponseEntity.ok(lists);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteByIdItemUnit(@PathVariable Long id){
        itemUnitService.deleteById(id);
        return ResponseEntity.ok("Delete success");
    }
}

package com.example.mini_pos.mapper.helper;

import com.example.mini_pos.model.entity.Brand;
import com.example.mini_pos.model.entity.Category;
import com.example.mini_pos.model.entity.ItemUnit;
import com.example.mini_pos.service.BrandService;
import com.example.mini_pos.service.CategoryService;
import com.example.mini_pos.service.ItemUnitService;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperHelper {
    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ItemUnitService itemUnitService;

    @Named("getBrandById")
    public Brand getBrandById(Long id) {
        if(id == null) {
            return null;
        }
        return brandService.getById(id);
    }

    @Named("getCategoryById")
    public Category getCategoryById(Long id) {
        if(id == null) {
            return null;
        }
        return categoryService.getById(id);
    }

    @Named("getItemUnitById")
    public ItemUnit getItemUnitById(Long id) {
        if(id == null) {
            return null;
        }
        return itemUnitService.getById(id);
    }

}

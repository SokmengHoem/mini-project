package com.example.mini_pos.mapper;

import com.example.mini_pos.mapper.helper.MapperHelper;
import com.example.mini_pos.model.entity.ItemProduct;
import com.example.mini_pos.model.request.ItemProductRequest;
import com.example.mini_pos.model.response.ItemProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {MapperHelper.class})
public interface ItemProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "brand", source = "brandId", qualifiedByName = "getBrandById")
    @Mapping(target = "category", source = "categoryId", qualifiedByName = "getCategoryById")
    @Mapping(target = "itemUnit", source = "itemUnitId", qualifiedByName = "getItemUnitById")
    @Mapping(target = "purchaseItemUnit", source = "purchaseItemUnitId", qualifiedByName = "getItemUnitById")
    @Mapping(target = "saleItemUnit", source = "saleItemUnitId", qualifiedByName = "getItemUnitById")
    ItemProduct toEntity(ItemProductRequest dto);

    // Correcting the field mappings based on your entities
    @Mapping(target = "brandName", source = "brand.name")
    @Mapping(target = "categoryName", source = "category.categoryName")
    @Mapping(target = "itemUnitName", source = "itemUnit.itemUnitName") // Replace with the correct field from your ItemUnit entity
    @Mapping(target = "purchaseItemUnitName", source = "purchaseItemUnit.itemUnitName") // Replace with the correct field from your ItemUnit entity
    @Mapping(target = "saleItemUnitName", source = "saleItemUnit.itemUnitName") // Replace with the correct field from your ItemUnit entity
    ItemProductResponse toDTO(ItemProduct entity);
}

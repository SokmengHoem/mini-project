package com.example.mini_pos.mapper;

import com.example.mini_pos.model.entity.ItemUnit;
import com.example.mini_pos.model.request.ItemUnitRequest;
import com.example.mini_pos.model.response.ItemUnitResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemUnitMapper {

    // Map from RequestDTO to Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "children", ignore = true)
    @Mapping(target = "parent.id", source = "parentId")
    ItemUnit toEntity(ItemUnitRequest request);

    // Map from Entity to ResponseDTO
    @Mapping(target = "parentId", source = "parent.id")  // Recursively map the parent object
    @Mapping(target = "children", source = "children")  // Recursively map the children
    ItemUnitResponse toDTO(ItemUnit itemUnit);
}


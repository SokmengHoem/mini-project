package com.example.mini_pos.mapper;

import com.example.mini_pos.model.entity.Category;
import com.example.mini_pos.model.request.CategoryRequest;
import com.example.mini_pos.model.response.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "children", ignore = true)
    @Mapping(target = "parent.id", source = "parentId")
    Category toEntity(CategoryRequest categoryRequest);

    @Mapping(target = "parentId", source = "parent.id")
    CategoryResponse toDTO(Category entity);
}

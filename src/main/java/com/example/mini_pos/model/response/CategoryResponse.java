package com.example.mini_pos.model.response;

import com.example.mini_pos.model.entity.Category;
import lombok.Data;

import java.util.List;

@Data
public class CategoryResponse {
    private Long id;
    private String categoryName;
    private String categoryCode;
    private String imagePath;
    private Long parentId;
    private List<CategoryResponse> children;
}

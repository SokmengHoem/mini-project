package com.example.mini_pos.service;

import com.example.mini_pos.model.entity.Category;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CategoryService {
    Category create(Category category);
    Category getById(Long id);
    Category update(Long id, Category category);
    Category saveImage(Long id, MultipartFile file) throws IOException, java.io.IOException;
}

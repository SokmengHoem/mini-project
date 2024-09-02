package com.example.mini_pos.service.impl;

import com.example.mini_pos.execption.ResourceNotFoundException;
import com.example.mini_pos.model.entity.Category;
import com.example.mini_pos.repositories.CategoryRepository;
import com.example.mini_pos.service.CategoryService;
import com.example.mini_pos.service.GenerateNewFileNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final GenerateNewFileNameService generateNewFileNameService;

    @Value("${app.basePath}")
    private String basePath;

    @Override
    public Category create(Category category) {

        Category parentEntityCategory = new Category();
        parentEntityCategory.setCategoryName(category.getCategoryName());
        parentEntityCategory.setCategoryCode(category.getCategoryCode());

        if(category.getParent() != null && category.getParent().getId() != null) {
            parentEntityCategory.setParent(category.getParent());
        }

        return categoryRepository.save(parentEntityCategory);
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("Category", id));
    }

    @Override
    public Category update(Long id, Category category) {
        Category categoryEntity = getById(id);
        categoryEntity.setCategoryName(category.getCategoryName());
        categoryEntity.setCategoryCode(category.getCategoryCode());

        if(category.getParent() != null && category.getParent().getId() != null){
            Category parentCategory = getById(category.getParent().getId());
            categoryEntity.setParent(parentCategory);
        }else {
            categoryEntity.setParent(null);
        }
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public Category saveImage(Long id, MultipartFile file) throws IOException, IOException {
        String newFileName = generateNewFileNameService.generateNewFileName(file.getOriginalFilename());
        //Get the path to the static/images directory

        String destinationPath = basePath + newFileName;
        file.transferTo(new File(destinationPath));
        Category saveImageCategory = getById(id);
        saveImageCategory.setImagePath(newFileName);
        return categoryRepository.save(saveImageCategory);
    }
}

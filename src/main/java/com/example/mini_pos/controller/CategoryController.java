package com.example.mini_pos.controller;

import com.example.mini_pos.mapper.CategoryMapper;
import com.example.mini_pos.model.entity.Category;
import com.example.mini_pos.model.request.CategoryRequest;
import com.example.mini_pos.model.response.CategoryResponse;
import com.example.mini_pos.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest request){
        Category category = categoryMapper.toEntity(request);
        Category created = categoryService.create(category);
        CategoryResponse response = categoryMapper.toDTO(created);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryResponse> getByIdCategory(@PathVariable Long id){
        Category category = categoryService.getById(id);
        CategoryResponse response = categoryMapper.toDTO(category);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable Long id, @RequestBody CategoryRequest request){
        Category entity = categoryMapper.toEntity(request);
        Category category = categoryService.update(id, entity);
        CategoryResponse response = categoryMapper.toDTO(category);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/image/{id}")
    public ResponseEntity<?> createImage(@PathVariable Long id, @RequestParam MultipartFile file) throws IOException, IOException {
        if(file.isEmpty()){
            return new ResponseEntity<>("Please select a file to upload", HttpStatus.BAD_REQUEST);
        }

        //Check if the upload file is an image
        if(!file.getContentType().startsWith("image")) {
            return new ResponseEntity<>("Please upload an image file", HttpStatus.BAD_REQUEST);
        }
        Category entity = categoryService.saveImage(id, file);
        CategoryResponse response = categoryMapper.toDTO(entity);
        return ResponseEntity.ok(response);
    }
}

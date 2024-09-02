package com.example.mini_pos.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CategoryRequest {
    @NotBlank(message = "Name is required.")
    @NotNull(message = "Name can't null.")
    @Length(max = 150 , message = "Name maximum 150 characters.")
    private String categoryName;

    @Length(max = 10  , message = "Code maximum 10 characters.")
    private String categoryCode;

    private Long parentId;

    private String imagePath;
}

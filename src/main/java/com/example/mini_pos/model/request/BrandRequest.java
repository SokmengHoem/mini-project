package com.example.mini_pos.model.request;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BrandRequest {
	@NotBlank(message = "Name is mandatory")
	@Length(min = 3, max = 150, message = "Name br between 3 and 150 characters")
	private String name;
}

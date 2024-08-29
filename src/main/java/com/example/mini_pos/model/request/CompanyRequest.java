package com.example.mini_pos.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CompanyRequest {

    @NotBlank(message = "company local name is required.")
    @Size(max = 255, message = "Company local name must be less than or equal to 255 characters.")
    private String companyLocalName;

    @Email(message = "Company email should be a valid email address.")
    @NotBlank(message = "Company email is required.")
    @Size(max = 255, message = "Company email must be less than or equal to 255 characters.")
    private String companyEmail;

    @NotBlank(message = "Company address is required.")
    @Size(max = 255, message = "Company address must be less than or equal to 255 characters.")
    private String companyAddress;

    @NotBlank(message = "VAT number is required.")
    @Size(max = 50, message = "VAT number must be less than or equal to 50 characters.")
    private String vatNumber;

    @Size(max = 255, message = "Image path must be less than or equal to 255 characters.")
    private String imagePath;

    @Size(max = 255, message = "Image name must be less than or equal to 255 characters.")
    private String image;
}

package com.example.mini_pos.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerRequest {

    @NotBlank(message = "Customer local name is required.")
    @Size(max = 255, message = "Customer local name must be less than or equal to 255 characters.")
    private String customerLocalName;

    @NotBlank(message = "Customer English name is required.")
    @Size(max = 255, message = "Customer English name must be less than or equal to 255 characters.")
    private String customerEngName;

    @Email(message = "Customer email should be a valid email address.")
    @NotBlank(message = "Customer email is required.")
    @Size(max = 255, message = "Customer email must be less than or equal to 255 characters.")
    private String customerEmail;

    @NotBlank(message = "Customer phone is required.")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Customer phone must be a valid phone number with 10 to 15 digits.")
    private String customerPhone;

    @NotBlank(message = "Customer address is required.")
    @Size(max = 255, message = "Customer address must be less than or equal to 255 characters.")
    private String customerAddress;
}

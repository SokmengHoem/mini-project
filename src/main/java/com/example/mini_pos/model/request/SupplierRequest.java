package com.example.mini_pos.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SupplierRequest {

    @NotBlank(message = "Supplier local name is required.")
    @Size(max = 255, message = "Supplier local name must be less than or equal to 255 characters.")
    private String supplierLocalName;

    @NotBlank(message = "Supplier Eng name is required.")
    @Size(max = 255, message = "Supplier Eng name must be less than or equal to 255 characters.")
    private String supplierEngName;

    @Email(message = "Supplier email should be a valid email address.")
    @NotBlank(message = "Supplier email is required.")
    @Size(max = 255, message = "Supplier email must be less than or equal to 255 characters.")
    private String supplierEmail;

    @NotBlank(message = "Supplier phone is required.")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Supplier phone must be a valid phone number with 10 to 15 digits.")
    private String supplierPhone;

    @NotBlank(message = "Supplier address is required.")
    @Size(max = 255, message = "Supplier address must be less than or equal to 255 characters.")
    private String supplierAddress;

    @NotBlank(message = "VAT number is required.")
    @Size(max = 50, message = "VAT number must be less than or equal to 50 characters.")
    private String vatNumber;
}

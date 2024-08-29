package com.example.mini_pos.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GeneralSettingRequest {
    @NotBlank(message = "Site title is required.")
    @Size(max = 255, message = "Site title must be less than or equal to 255 characters.")
    private String siteTitle;

    @NotBlank(message = "Site logo is required.")
    @Size(max = 255, message = "Site logo must be less than or equal to 255 characters.")
    private String siteLogo;

    @NotBlank(message = "Site phone is required.")
    @Size(max = 20, message = "Site phone must be less than or equal to 20 characters.")
    private String sitePhone;

    @NotBlank(message = "Site address is required.")
    @Size(max = 255, message = "Site address must be less than or equal to 255 characters.")
    private String siteAddress;

}

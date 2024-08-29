package com.example.mini_pos.model.response;

import lombok.Data;

@Data
public class CompanyResponse {
    private Long id;

    private String companyLocalName;

    private String companyEmail;

    private String companyAddress;

    private String vatNumber;

    private String imagePath;

    private String image;
}

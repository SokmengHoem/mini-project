package com.example.mini_pos.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyLocalName;

    private String companyEmail;

    private String companyAddress;

    private String vatNumber;

    private String imagePath;

    private String image;

    private boolean isDeleted;
}

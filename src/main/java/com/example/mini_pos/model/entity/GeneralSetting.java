package com.example.mini_pos.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "generalSettings")
public class GeneralSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String siteTitle;

    private String siteLogo;

    private String sitePhone;

    private String siteAddress;

    private boolean isDeleted;
}

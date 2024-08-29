package com.example.mini_pos.model.response;

import lombok.Data;

@Data
public class GeneralSettingResponse {
    private Long id;

    private String siteTitle;

    private String siteLogo;

    private String sitePhone;

    private String siteAddress;
}

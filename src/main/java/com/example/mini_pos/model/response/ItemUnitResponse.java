package com.example.mini_pos.model.response;

import com.example.mini_pos.model.enums.EnumItemUnit;
import lombok.Data;

import java.util.List;

@Data
public class ItemUnitResponse {

    private Long id;
    private String itemUnitCode;
    private String itemUnitName;
    private EnumItemUnit operator;
    private Double operationValue;
    private Long parentId; //Nested parent information
    private List<ItemUnitResponse> children; //Nested children
}

package com.example.mini_pos.model.request;

import com.example.mini_pos.model.enums.EnumItemUnit;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ItemUnitRequest {

    @NotBlank(message = "Item unit code is required")
    private String itemUnitCode;

    @NotBlank(message = "Item unit name is required")
    private String itemUnitName;

    @NotNull(message = "Operator is required")
    private EnumItemUnit operator;

    @NotNull(message = "Operation value is required")
    private Double operationValue;

    private Long parentId;
}

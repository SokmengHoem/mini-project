package com.example.mini_pos.model.request;

import com.example.mini_pos.model.enums.EnumProduct;
import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class ItemProductRequest {

    @NotBlank(message = "Product name is required")
    @Size(max = 150, message = "Product name can't exceed 150 characters")
    private String productName;

    @NotBlank(message = "Product code is required")
    @Size(max = 30, message = "Product code can't exceed 30 characters")
    private String productCode;

    @NotNull(message = "Product type is required")
    private EnumProduct productType;

    @NotBlank(message = "Barcode symbology is required")
    @Size(max = 30, message = "Barcode symbology can't exceed 30 characters")
    private String barcodeSymbology;

    @NotNull(message = "Cost is required")
    @PositiveOrZero(message = "Cost must be positive or zero")
    private Double cost;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotNull(message = "Quantity is required")
    @PositiveOrZero(message = "Quantity must be positive or zero")
    private Integer qty;

    @NotNull(message = "Alert quantity is required")
    @PositiveOrZero(message = "Alert quantity must be positive or zero")
    private Integer alertQty;

    @Size(max = 250, message = "Image URL can't exceed 250 characters")
    private String image;

    @NotBlank(message = "Image path is required")
    private String imagePath;

    private boolean isOverridePrice = false;
    private boolean isShowInPos = true;

    @NotNull(message = "Brand ID is required")
    private Long brandId;

    @NotNull(message = "Category ID is required")
    private Long categoryId;

    @NotNull(message = "Item unit ID is required")
    private Long itemUnitId;

    @NotNull(message = "Purchase item unit ID is required")
    private Long purchaseItemUnitId;

    @NotNull(message = "Sale item unit ID is required")
    private Long saleItemUnitId;
}
package com.example.mini_pos.model.response;

import com.example.mini_pos.model.enums.EnumProduct;
import lombok.Data;

@Data
public class ItemProductResponse {

    private Long id;
    private String productName;
    private String productCode;
    private EnumProduct productType;
    private String barcodeSymbology;
    private Double cost;
    private Double price;
    private Integer qty;
    private Integer alertQty;
    private String imagePath;
    private String image;
    private boolean isOverridePrice;
    private boolean isShowInPos;
    private String brandName; //Related brand name
    private String categoryName; //Related category
    private String itemUnitName; //Main item unit name
    private String purchaseItemUnitName; //Purchase item
    private String saleItemUnitName;// sale item unit name
}

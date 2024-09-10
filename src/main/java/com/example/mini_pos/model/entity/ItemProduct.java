package com.example.mini_pos.model.entity;

import com.example.mini_pos.model.enums.EnumProduct;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class ItemProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", length = 150)
    private String productName;

    @Column(name = "product_code", length = 30)
    private String productCode;

    @Column(name = "product_type", length = 10)
    @Enumerated(EnumType.STRING)
    private EnumProduct productType;

    @Column(name = "barcode_symbology", length = 30)
    private String barcodeSymbology;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "price")
    private Double price;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "alert_qty")
    private Integer alertQty;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "image", length = 250)
    private String image;

    @Column(name = "is_override_price", columnDefinition = "boolean default false")
    private boolean isOverridePrice;

    @Column(name = "is_show_in_pos", columnDefinition = "boolean default true")
    private boolean isShowInPos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "item_unit_id")
    private  ItemUnit itemUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_item_unit_id")
    private  ItemUnit purchaseItemUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_item_unit_id")
    private ItemUnit saleItemUnit;

    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted;
}

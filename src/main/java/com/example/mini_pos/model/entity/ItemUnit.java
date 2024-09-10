package com.example.mini_pos.model.entity;

import com.example.mini_pos.model.enums.EnumItemUnit;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "itemUnits")
@Data
public class ItemUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_unit_code", length = 10)
    private String itemUnitCode;

    @Column(name = "item_unit_name", length = 150)
    private String itemUnitName; // Fixed typo

    @Enumerated(EnumType.STRING)
    @Column(name = "operator", length = 10)
    private EnumItemUnit operator;

    @Column(name = "operation_value")
    private Double operationValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @JsonBackReference // Back reference to avoid circular references in JSON serialization
    private ItemUnit parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference // Managed reference for child serialization
    private List<ItemUnit> children;

    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted;
}

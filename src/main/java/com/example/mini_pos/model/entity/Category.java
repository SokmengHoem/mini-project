package com.example.mini_pos.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name", length = 150)
    private String categoryName;

    @Column(name = "category_code",length = 10)
    private String categoryCode;

    @Column(name = "image_path",length = 250)
    private String imagePath;

    @Column(name = "is_deleted",columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean isDeleted = false;

    //make with sub Category
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private Category   parent;

    @OneToMany(mappedBy = "parent",fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Category> children;
}

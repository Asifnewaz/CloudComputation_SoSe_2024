package com.asif.cc_summer.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Category extends BaseClass {
    private String categoryName;
    private String image;

    public Category(String categoryName, String image){
        this.categoryName = categoryName;
        this.image = image;
    }
}

package com.asif.cc_summer.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Category extends BaseClass {
    private String categoryName;
    private String image;
}

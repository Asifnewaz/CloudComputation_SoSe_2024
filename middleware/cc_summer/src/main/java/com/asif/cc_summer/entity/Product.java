package com.asif.cc_summer.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Product extends BaseClass{

    private String product_id;
    private String name;
    private String category_name;
    private String image;
    private Double price;
    private String full_description;
    private Integer available_product;
}

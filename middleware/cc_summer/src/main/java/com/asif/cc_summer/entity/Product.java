package com.asif.cc_summer.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Product extends BaseClass{

    private String Product_id;
    private String Product_name;
    private String Category_name;
    private String Product_images;
    private Double Product_price;
    private String Full_description;
    private Integer Available_product;
}

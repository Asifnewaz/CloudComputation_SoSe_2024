package com.asif.cc_summer.dto.request;

import lombok.Data;

@Data
public class ProductDto  {
    private String name;

    private String full_description;
    private String image;
    private Long category_id;

    private Double price;
    private Integer available_product;
}

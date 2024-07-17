package com.asif.cc_summer.dto.request;

import lombok.Data;

@Data
public class ProductDto  {
    private Long id;

    private String name;

    private String productDescription;

    private Double price;
}

package com.asif.cc_summer.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartListResponse {
    public Long id;
    public Long product_id;
    public String name;
    public Double price;
    public Integer quantity;
    public String image;


}

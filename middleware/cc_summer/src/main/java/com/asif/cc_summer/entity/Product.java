package com.asif.cc_summer.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Product extends BaseClass{

    private String name;

    private String productDescription;

    private Double price;

}

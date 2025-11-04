package com.scaler.productservice1.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Integer id;
    private String title;
    private String description;
    private float price;
    private String image;
    private Category category;
}

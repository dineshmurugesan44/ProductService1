package com.scaler.productservice1.dto;

import com.scaler.productservice1.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    private String title;
    private Float price;
    private String description;
    private String category;
    private String image;
}

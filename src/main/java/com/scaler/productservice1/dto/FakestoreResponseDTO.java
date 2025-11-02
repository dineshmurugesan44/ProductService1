package com.scaler.productservice1.dto;

import com.scaler.productservice1.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakestoreResponseDTO {
    private int id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;

}

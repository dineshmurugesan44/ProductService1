package com.scaler.productservice1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStorePostResponseDTO {
    private Integer id;
    private String title;
    private Float price;
    private String description;
    private String Category;
    private String image;
}

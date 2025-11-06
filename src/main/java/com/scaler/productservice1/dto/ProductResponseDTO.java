package com.scaler.productservice1.dto;

import com.scaler.productservice1.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {

    private Product product;
    private String message;


}

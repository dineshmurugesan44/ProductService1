package com.scaler.productservice1.dto;

import com.scaler.productservice1.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllProductsResponseDTO {
    private List<Product> products;
    private String message;
}

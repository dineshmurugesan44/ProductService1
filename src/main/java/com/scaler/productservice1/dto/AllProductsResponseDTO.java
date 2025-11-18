package com.scaler.productservice1.dto;

import com.scaler.productservice1.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllProductsResponseDTO {
    private Page<Product> products;
    private String message;
}

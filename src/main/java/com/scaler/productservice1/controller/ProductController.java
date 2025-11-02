package com.scaler.productservice1.controller;

import com.scaler.productservice1.model.Product;
import com.scaler.productservice1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") int product_id) {
        Product product = productService.getProductById(product_id);
        return product;

    }
}

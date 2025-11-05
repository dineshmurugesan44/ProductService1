package com.scaler.productservice1.controller;

import com.scaler.productservice1.dto.FakeStorePostRequestDTO;
import com.scaler.productservice1.model.Product;
import com.scaler.productservice1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") int product_id) {
        Product product = productService.getProductById(product_id);
        return product;

    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        List<Product> AllProducts = productService.getAllProducts();

        return AllProducts;

    }
   @PostMapping("/products")
    public Product addProduct(@RequestBody FakeStorePostRequestDTO fakeStorePostRequestDTO) {

        Product added_product = productService.addProduct(fakeStorePostRequestDTO);
        return added_product;
    }
}

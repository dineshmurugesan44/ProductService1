package com.scaler.productservice1;

import com.scaler.productservice1.model.Product;
import com.scaler.productservice1.repository.CategoryRepository;
import com.scaler.productservice1.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class ProductService1ApplicationTests {
    @Autowired
    private ProductRepository productRepository;


    @Test
    void contextLoads() {
    }

    @Test
    void GetAllProductsHQL() {
        List<Product> products = productRepository.findAllUsingHQL();
        for (Product product : products) {
            System.out.println(product.getTitle());
        }
    }

    @Test
    void GetAllProductsByCategoryNameJPA() {
        List<Product> products = productRepository.findAllByCategory_Name("Mobiles");
        for (Product product : products) {
            System.out.println(product.getTitle());
        }

    }
    @Test
    void GetAllProductsByCategoryNameHQL() {
        List<Product> products = productRepository.findAllByCategoryNameHQL("Mobiles");
        for (Product product : products) {
            System.out.println(product.getTitle());
        }

    }




}

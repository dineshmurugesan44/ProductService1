package com.scaler.productservice1;

import com.scaler.productservice1.model.Product;
import com.scaler.productservice1.projections.PriceDescriptionProjection;
import com.scaler.productservice1.projections.ProductProjection;
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

    @Test
    void GetAllProductsByCategoryNameNativeSQL() {
        List<Product> products = productRepository.findAllByCategoryNameSQL("TV");
        for (Product product : products) {
            System.out.println(product);
        }

    }
    @Test
    void GetProuctsByProjectionsHQL(){
        List<ProductProjection> projectedProductDetails = productRepository.findAllProductProjection(1L);
        for(ProductProjection projection : projectedProductDetails){
            System.out.println("ID: "+ projection.getId());
            System.out.println("Name: "+projection.getTitle());

        }
    }

    @Test
    void GetProuctsByProjectionsSQL(){
        List<PriceDescriptionProjection> projectedProductDetails = productRepository.findAllPriceDescriptionProjection("Mobiles");
        for(PriceDescriptionProjection projection : projectedProductDetails){
            System.out.println("Description: "+ projection.getDescription());
            System.out.println("Price: "+ projection.getPrice());

        }
    }




}

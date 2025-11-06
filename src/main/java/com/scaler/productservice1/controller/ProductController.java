package com.scaler.productservice1.controller;

import com.scaler.productservice1.dto.AllProductsResponseDTO;
import com.scaler.productservice1.dto.FakeStorePostRequestDTO;
import com.scaler.productservice1.dto.ProductResponseDTO;
import com.scaler.productservice1.exceptions.ProductIdCannotBeNegative;
import com.scaler.productservice1.model.Product;
import com.scaler.productservice1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;



    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("id") int product_id) throws ProductIdCannotBeNegative {

        Product product = productService.getProductById(product_id);

        /*catch(DBNotFoundException e2){
            return new ResponseEntity<>(new ErrorResponseDTO(null, "FAILURE " +e2.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }*/


        return new ResponseEntity<>(new ProductResponseDTO(product, "SUCCESS"), HttpStatus.OK);

    }

    @GetMapping("/products")
    public  ResponseEntity<AllProductsResponseDTO> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(new AllProductsResponseDTO(products, "SUCCESS"), HttpStatus.OK);

    }


   @PostMapping("/products")
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody FakeStorePostRequestDTO fakeStorePostRequestDTO) {

        Product product = productService.addProduct(fakeStorePostRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductResponseDTO(product, "SUCCESS"));
    }
}

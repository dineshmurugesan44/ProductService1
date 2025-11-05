package com.scaler.productservice1.controller;

import com.scaler.productservice1.dto.ErrorResponseDTO;
import com.scaler.productservice1.dto.FakeStorePostRequestDTO;
import com.scaler.productservice1.exceptions.DBNotFoundException;
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
    public ResponseEntity<ErrorResponseDTO> getProductById(@PathVariable("id") int product_id)  {
        try {
            Product product = productService.getProductById(product_id);
            return new ResponseEntity<>(new ErrorResponseDTO(product, "Success"), HttpStatus.OK);
        }
        catch (NullPointerException e) {

            return new ResponseEntity<>(new ErrorResponseDTO(null, "FAILURE " +e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        catch (ProductIdCannotBeNegative e1) {
            return new ResponseEntity<>(new ErrorResponseDTO(null, "FAILURE " +e1.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        /*catch(DBNotFoundException e2){
            return new ResponseEntity<>(new ErrorResponseDTO(null, "FAILURE " +e2.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }*/


    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {

        List<Product> products = productService.getAllProducts();
        return products;
    }
   @PostMapping("/products")
    public Product addProduct(@RequestBody FakeStorePostRequestDTO fakeStorePostRequestDTO) {

        Product product = productService.addProduct(fakeStorePostRequestDTO);
        return product;
    }
}

package com.scaler.productservice1.service;

import com.scaler.productservice1.dto.FakeStorePostRequestDTO;
import com.scaler.productservice1.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product getProductById(int product_id);
    List<Product> getAllProducts();

    Product addProduct(FakeStorePostRequestDTO fakeStorePostRequestDTO);
}

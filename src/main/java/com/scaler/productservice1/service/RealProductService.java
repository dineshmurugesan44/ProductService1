package com.scaler.productservice1.service;

import com.scaler.productservice1.dto.FakeStorePostRequestDTO;
import com.scaler.productservice1.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealProductService implements ProductService {
    @Override
    public Product getProductById(int product_id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product addProduct(FakeStorePostRequestDTO fakeStorePostRequestDTO) {
        return null;
    }
}

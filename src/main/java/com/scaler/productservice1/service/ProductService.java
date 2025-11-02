package com.scaler.productservice1.service;

import com.scaler.productservice1.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public interface ProductService {
    Product getProductById(int product_id);
}

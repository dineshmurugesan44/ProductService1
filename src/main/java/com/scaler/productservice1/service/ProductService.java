package com.scaler.productservice1.service;

import com.scaler.productservice1.dto.ProductRequestDTO;
import com.scaler.productservice1.exceptions.ProductIdCannotBeNegative;
import com.scaler.productservice1.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    Product getProductById(Long product_id) throws ProductIdCannotBeNegative;
    Page<Product> getAllProducts(Integer pageSize, Integer pageNo, String sortDirection, String[] sortBy) throws ProductIdCannotBeNegative;
    Product addProduct(ProductRequestDTO productRequestDTO);


}

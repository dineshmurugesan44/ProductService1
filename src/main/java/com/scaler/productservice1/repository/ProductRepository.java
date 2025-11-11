package com.scaler.productservice1.repository;

import com.scaler.productservice1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

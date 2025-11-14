package com.scaler.productservice1.repository;

import com.scaler.productservice1.model.Category;
import com.scaler.productservice1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product product);

    Optional<Product>findById(long id);

    List<Product>findAll();

    List<Product> findAllByCategory_Name(String name);

    @Query("select p from Product p")
    List<Product> findAllUsingHQL();

    @Query("select p from Product p where p.category.name=:catName")
    List<Product>findAllByCategoryNameHQL(@Param("catName") String name);

}

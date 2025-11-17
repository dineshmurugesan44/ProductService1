package com.scaler.productservice1.repository;

import com.scaler.productservice1.model.Category;
import com.scaler.productservice1.model.Product;
import com.scaler.productservice1.projections.PriceDescriptionProjection;
import com.scaler.productservice1.projections.ProductProjection;
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

    //using Projection with HQL.

    @Query("select p.id as id, p.title as title from Product p where p.category.id=:catID")
    List<ProductProjection>findAllProductProjection(@Param("catID") Long id);

    //Using Projection with NativeSQL
    @Query(value = "select p.description as description, p.price as price from products as p left join categories as c on p.category_id = c.id where c.name= :catName ", nativeQuery = true)
    List<PriceDescriptionProjection>findAllPriceDescriptionProjection(@Param("catName") String catName);

    //using HQL QUERY

    @Query("select p from Product p")
    List<Product> findAllUsingHQL();

    @Query("select p from Product p where p.category.name=:catName")
    List<Product>findAllByCategoryNameHQL(@Param("catName") String name);

    //USING NativeSQl

    @Query(value = "select p.* from products p left join categories c on p.category_id = c.id where c.name = :catName", nativeQuery = true)
    List<Product>findAllByCategoryNameSQL(@Param("catName") String name);

}

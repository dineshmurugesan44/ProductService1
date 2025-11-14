package com.scaler.productservice1.service;

import com.scaler.productservice1.dto.ProductRequestDTO;
import com.scaler.productservice1.exceptions.ProductIdCannotBeNegative;
import com.scaler.productservice1.exceptions.ProductNotFoundException;
import com.scaler.productservice1.model.Category;
import com.scaler.productservice1.model.Product;
import com.scaler.productservice1.repository.CategoryRepository;
import com.scaler.productservice1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("RealProductService")
 public class RealProductService implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public RealProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long product_id) throws ProductIdCannotBeNegative {
        if(product_id<1){
            throw new ProductIdCannotBeNegative("Product Id cannot be zero or negative");
        }
        Product product = productRepository.findById(product_id)
                .orElseThrow(() -> new ProductNotFoundException("Give valid product id"));
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;

    }

    @Override
    public Product addProduct(ProductRequestDTO productRequestDTO) {

        Product product = new Product();
        product.setTitle(productRequestDTO.getTitle());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setImage(productRequestDTO.getImage());

        Category category = new Category();
        category.setName( productRequestDTO.getCategory());

        product.setCategory(category);


        // PRODUCT WILL ALWAYS HAVE NEW ID -> Before creating product we must check wheather category is present or not
        //if present we can create new category or we use old category.
        Optional<Category> optionalCategory = categoryRepository.findByName(product.getCategory().getName());

        if (optionalCategory.isPresent()) {
            product.setCategory(optionalCategory.get());
        }
        else{
            Category newCategory = new Category();
            newCategory.setName(product.getCategory().getName());
            Category savedCategory = categoryRepository.save(newCategory);
            product.setCategory(savedCategory);
        }

        return productRepository.save(product);

    }
}

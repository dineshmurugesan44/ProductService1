package com.scaler.productservice1.service;

import com.scaler.productservice1.dto.ProductRequestDTO;
import com.scaler.productservice1.exceptions.ProductIdCannotBeNegative;
import com.scaler.productservice1.exceptions.ProductNotFoundException;
import com.scaler.productservice1.model.Category;
import com.scaler.productservice1.model.Product;
import com.scaler.productservice1.repository.CategoryRepository;
import com.scaler.productservice1.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
    public Page<Product> getAllProducts(Integer pageSize, Integer pageNo, String sortDirection, String[] sortBy) {
        Sort.Direction direction = Sort.Direction.fromString(sortDirection);
        Page<Product> products = productRepository.findAll(PageRequest.of(pageNo, pageSize, direction, sortBy));
        return products;

    }

    @Override
    public Product addProduct(ProductRequestDTO productRequestDTO) {

        Product product = productRequestDTO.toProduct();


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

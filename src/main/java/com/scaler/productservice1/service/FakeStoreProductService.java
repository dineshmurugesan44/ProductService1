package com.scaler.productservice1.service;

import com.scaler.productservice1.dto.FakeStoreGetResponseDTO;
import com.scaler.productservice1.dto.FakeStorePostResponseDTO;
import com.scaler.productservice1.dto.ProductRequestDTO;
import com.scaler.productservice1.exceptions.ProductIdCannotBeNegative;
import com.scaler.productservice1.exceptions.ProductNotFoundException;
import com.scaler.productservice1.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreService")
public class FakeStoreProductService implements ProductService {
    @Autowired
    RestTemplate restTemplate;



    @Override
    public Product getProductById(Long product_id) throws ProductIdCannotBeNegative {

        if(product_id<1){
            throw new ProductIdCannotBeNegative("Product Id cannot be zero or negative");
        }
        FakeStoreGetResponseDTO fakestoreResponse =  restTemplate.getForObject
                ("https://fakestoreapi.com/products/" + product_id, FakeStoreGetResponseDTO.class);

        if(fakestoreResponse == null){
            throw new ProductNotFoundException("Product not found");
        }

        return fakestoreResponse.toProduct();

    }

    @Override
    public Page<Product> getAllProducts(Integer pageSize, Integer pageNo, String sortDirection, String[] sortBy) throws ProductIdCannotBeNegative {
        FakeStoreGetResponseDTO[] response = restTemplate.getForObject
                ("https://fakestoreapi.com/products", FakeStoreGetResponseDTO[].class);

        List<Product> products = new ArrayList<>();

        for(FakeStoreGetResponseDTO fakeStoreGetResponseDTO : response){
            if(fakeStoreGetResponseDTO == null){
                throw new ProductNotFoundException("Product not found");
            }
            products.add(fakeStoreGetResponseDTO.toProduct());
        }

        // Manual pagination
        int startIndex = pageNo * pageSize;
        int endIndex = Math.min(startIndex + pageSize, products.size());

        List<Product> paginatedProducts = products.subList(startIndex, endIndex);

        // Return as a Page
        return new PageImpl<>(
                paginatedProducts,
                PageRequest.of(pageNo, pageSize),
                products.size()
        );
    }

    @Override
    public Product addProduct(ProductRequestDTO productRequestDTO) {

        FakeStorePostResponseDTO response =
                restTemplate.postForObject("https://fakestoreapi.com/products", productRequestDTO, FakeStorePostResponseDTO.class);

        if(response == null){
            throw new ProductNotFoundException("Product not found");
        }

        return response.toProduct();
    }

    //creating common fakestoreresponse to product to follow DRY(DON'T REPEAT YOUR CODE)
    /*public Product ConvertFakeStoreResponseToProduct(FakeStoreGetResponseDTO fakestoreResponse){
        Product product = new Product();
        product.setId(fakestoreResponse.getId());
        product.setTitle(fakestoreResponse.getTitle());
        product.setDescription(fakestoreResponse.getDescription());
        product.setPrice(fakestoreResponse.getPrice());
        product.setImage(fakestoreResponse.getImage());

        Category category = new Category();
        category.setName(fakestoreResponse.getCategory());

        product.setCategory(category);

        return product;


    }

    public Product CovertPostrequestResponseToProduct(FakeStorePostResponseDTO response){
        Product product = new Product();

        product.setId(response.getId());
        product.setTitle(response.getTitle());
        product.setDescription(response.getDescription());
        product.setPrice(response.getPrice());
        product.setImage(response.getImage());
        Category category = new Category();
        category.setName(response.getCategory());
        product.setCategory(category);

        return product; */

}

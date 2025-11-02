package com.scaler.productservice1.service;

import com.scaler.productservice1.dto.FakestoreResponseDTO;
import com.scaler.productservice1.model.Category;
import com.scaler.productservice1.model.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Primary
public class FakeStoreProductService implements ProductService {

    private final RestTemplate restTemplate = new RestTemplate();
    @Override
    public Product getProductById(int product_id) {
        FakestoreResponseDTO fakestoreResponse =  restTemplate.getForObject
                ("https://fakestoreapi.com/products/" + product_id, FakestoreResponseDTO.class);

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
}

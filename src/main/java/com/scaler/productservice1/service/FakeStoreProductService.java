package com.scaler.productservice1.service;

import com.scaler.productservice1.dto.FakeStoreGetResponseDTO;
import com.scaler.productservice1.dto.FakeStorePostRequestDTO;
import com.scaler.productservice1.dto.FakeStorePostResponseDTO;
import com.scaler.productservice1.model.Category;
import com.scaler.productservice1.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class FakeStoreProductService implements ProductService {
    @Autowired
    RestTemplate restTemplate;



    @Override
    public Product getProductById(int product_id) {
        FakeStoreGetResponseDTO fakestoreResponse =  restTemplate.getForObject
                ("https://fakestoreapi.com/products/" + product_id, FakeStoreGetResponseDTO.class);

        return fakestoreResponse.toProduct();


    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreGetResponseDTO[] response = restTemplate.getForObject
                ("https://fakestoreapi.com/products", FakeStoreGetResponseDTO[].class);

        List<Product> products = new ArrayList<>();

        for(FakeStoreGetResponseDTO fakeStoreGetResponseDTO : response){
            products.add(fakeStoreGetResponseDTO.toProduct());
        }

        return products;
    }

    @Override
    public Product addProduct(FakeStorePostRequestDTO fakeStorePostRequestDTO) {

        FakeStorePostResponseDTO response =
                restTemplate.postForObject("https://fakestoreapi.com/products", fakeStorePostRequestDTO, FakeStorePostResponseDTO.class);



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

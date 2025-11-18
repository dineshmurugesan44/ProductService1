package com.scaler.productservice1.dto;

import com.scaler.productservice1.model.Category;
import com.scaler.productservice1.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    private String title;
    private Float price;
    private String description;
    private String category;
    private String image;

    public Product toProduct() {
        Product product = new Product();
        product.setTitle(this.title);
        product.setPrice(this.price);
        product.setDescription(this.description);
        Category category = new Category();
        category.setName(this.category);
        product.setCategory(category);
        product.setImage(this.image);

        return product;
    }
}



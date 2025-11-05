package com.scaler.productservice1.dto;

import com.scaler.productservice1.model.Product;
import com.scaler.productservice1.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreGetResponseDTO {
    private Integer id;
    private String title;
    private Float price;
    private String description;
    private String Category;
    private String image;

    public Product toProduct() {
        Product product = new Product();
        product.setId(this.id);
        product.setTitle(this.title);
        product.setPrice(this.price);
        product.setDescription(this.description);
        product.setImage(this.image);

        Category category = new Category();

        category.setName(this.Category);

        product.setCategory(category);

        return product;



    }
}

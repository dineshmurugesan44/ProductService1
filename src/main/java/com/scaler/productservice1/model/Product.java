package com.scaler.productservice1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "products")
public class Product extends BaseModel {

    private String title;
    private String description;
    private float price;
    private String image;
    @ManyToOne
    private Category category;
}

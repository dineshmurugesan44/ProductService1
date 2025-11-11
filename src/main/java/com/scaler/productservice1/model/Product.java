package com.scaler.productservice1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String title;
    private String description;
    private float price;
    private String image;
    @ManyToOne
    private Category category;
}

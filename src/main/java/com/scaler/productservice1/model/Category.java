package com.scaler.productservice1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category extends BaseModel {
    private String name;
    //@OneToMany(mappedBy = "category")//you can also skip this.
    //ACTUALLY IT WAS INVERSE OF SAME THING DONE BY PRODUCT AND SAME RELATION BETWEEN
    //PRODUCT AND CATEGORY
    //private List<Product> products;
}




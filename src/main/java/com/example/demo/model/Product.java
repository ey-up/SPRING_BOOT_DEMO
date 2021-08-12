package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "products",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Seller> sellers;



}

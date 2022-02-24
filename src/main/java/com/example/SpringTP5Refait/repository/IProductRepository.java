package com.example.SpringTP5Refait.repository;

import com.example.SpringTP5Refait.domain.Product;

import java.util.List;

public interface IProductRepository {

    void create(Product produit);
    Product display(String name);
    List<Product> displayAll();
}

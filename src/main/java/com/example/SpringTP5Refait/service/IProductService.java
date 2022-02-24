package com.example.SpringTP5Refait.service;

import com.example.SpringTP5Refait.domain.Product;
import com.example.SpringTP5Refait.dto.ProductDto;

import java.util.List;

public interface IProductService {

    void create(ProductDto produitDto);
    ProductDto display(String name);
    List<ProductDto> displayAll();

}

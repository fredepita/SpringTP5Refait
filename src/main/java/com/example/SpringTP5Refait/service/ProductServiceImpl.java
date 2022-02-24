package com.example.SpringTP5Refait.service;

import com.example.SpringTP5Refait.domain.Product;
import com.example.SpringTP5Refait.dto.ProductDto;
import com.example.SpringTP5Refait.repository.IProductRepository;
import com.example.SpringTP5Refait.repository.ProductRepositoryFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Override
    public void create(ProductDto productDto){

        System.out.println("ProductServiceImpl-create");
        IProductRepository productRepository = ProductRepositoryFactory.getProductRepository();
        Product product = new Product(productDto.getName(), productDto.getPrice(),productDto.getDescription());
        productRepository.create(product);
    }

    @Override
    public ProductDto display(String name){

        System.out.println("ProductServiceImpl-display");
        IProductRepository productRepository = ProductRepositoryFactory.getProductRepository();
        Product product = productRepository.display(name);
        return new ProductDto(product.getName(),product.getPrice(), product.getDescription());
    }

    @Override
    public List<ProductDto> displayAll(){

        System.out.println("ProductServiceImpl-displayAll");
        IProductRepository productRepository = ProductRepositoryFactory.getProductRepository();

        List<Product> productList= productRepository.displayAll();
        List<ProductDto> productDtoList = new ArrayList<>();

        for (Product product:productList) {
            productDtoList.add(new ProductDto(product.getName(),product.getPrice(),product.getDescription()));
        }
        return productDtoList;
    }
}

package com.example.SpringTP5Refait.controller;

import com.example.SpringTP5Refait.dto.ProductDto;
import com.example.SpringTP5Refait.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    IProductService productService;

    @PostMapping("/product")
    public void create(@RequestBody ProductDto productDto){
        productService.create(productDto);
    }

    @GetMapping("/product/{name}")
    public ProductDto display (@PathVariable("name") String name){
        return(productService.display(name));
    }

    @GetMapping("/products")
    public List<ProductDto> displayAll () {
        List<ProductDto> productDtoList = productService.displayAll();

        for (ProductDto productDto:productDtoList){
            System.out.println(productDto.toString());
        }
        return productDtoList;
    }


}

package com.example.SpringTP5Refait.service;

public class ProductServiceFactory {

    public IProductService getProductService(){
        return new ProductServiceImpl();
    }
}

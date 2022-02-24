package com.example.SpringTP5Refait.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductRepositoryFactory {

    static SessionFactory sessionFactory;

    public static IProductRepository getProductRepository(){
        return new ProductRepositoryImpl();
    }

    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            sessionFactory = new Configuration().configure("hibernate-cfg.xml").buildSessionFactory();
        }
        return sessionFactory;
    }
}

package com.example.SpringTP5Refait.repository;

import com.example.SpringTP5Refait.domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository{

    @Override
    public void create(Product product){

        System.out.println("ProductRepositoryImpl-create");
        SessionFactory sessionFactory = ProductRepositoryFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //---> Requêtes
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        session.close();

        System.out.println("<-- Repository -->");
        System.out.println(" Product created");
        System.out.println(product.toString());


    }
    @Override
    public Product display(String name){
        System.out.println("ProductRepositoryImpl-display");
        SessionFactory sessionFactory = ProductRepositoryFactory.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            System.out.println("before query");
            System.out.println(("name : " + name));

            Query query = session.createQuery("select product from Product product where product.name = :name");
            query.setParameter("name", name);
            System.out.println("after query");
            //System.out.println(query.getResultList().toString());
            List<Product> productList = query.getResultList();
            if (!productList.isEmpty()){
                System.out.println("Liste non vide !!!");
                return productList.get(0);
            }
        } finally {
            session.close();
        }
        return null;
    }
    @Override
    public List<Product> displayAll(){
        System.out.println("ProductRepositoryImpl-displayAll");
        SessionFactory sessionFactory = ProductRepositoryFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Product> productList;
        try
        {
            Query query = session.createQuery("select product from Product product");
            productList = query.getResultList();
        }
        finally
        {
            session.close();
        }
        return productList;
    }
}

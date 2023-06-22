package com.musicworld.musicworld.repository;

import com.musicworld.musicworld.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepository {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    /*public void findAll(){
        String queryString = "FROM product";
        Query query = entityManagerFactory.createEntityManager().createQuery(queryString);
        List<Product> productList = query.getResultList();

        for (Product product : productList){
            System.out.println(product.getName());
        }
    }*/

    public List<Product> findAll(){
        return entityManagerFactory.createEntityManager().createQuery("from product").getResultList();
    }

    @Transactional
    public void delete(Product product){
        try{
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.createQuery("delete from product where id = :id")
                    .setParameter("id", product.getId())
                    .executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Transactional
    public void create(Product product) {
        try{
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.persist(product);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
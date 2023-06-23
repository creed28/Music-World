package com.musicworld.musicworld.repository;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public abstract class ParentRepository<T> {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public abstract String getEntityName();

    @PostConstruct
    public List<T> findAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from " + getEntityName()).getResultList();
    }

    @Transactional
    public void create(T object){
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.persist(object);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Transactional
    public void delete(long id) {
        try{
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.createQuery("delete from :type where id = :id")
                    .setParameter("type", getEntityName())
                    .setParameter("id", id)
                    .executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
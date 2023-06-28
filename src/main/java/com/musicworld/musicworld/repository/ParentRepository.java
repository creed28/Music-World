package com.musicworld.musicworld.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public abstract class ParentRepository<T> {

    @PersistenceContext
    private EntityManager entityManager;

    protected abstract Class<T> getEntityClass();

    public List<T> findAll(){
        return entityManager.createQuery("from " + getEntityClass().getSimpleName()).getResultList();
    }

   public T findById(Long id){
        return entityManager.find(getEntityClass(), id);
    }

    @Transactional
    public void create(T entity){
        try {
            entityManager.persist(entity);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Transactional
    public void update(T entity){
        try {
            entityManager.merge(entity);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Transactional
    public void delete(Long id) {
        try{
            entityManager.createQuery("delete from " + getEntityClass().getSimpleName() + " where id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
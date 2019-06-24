/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabuscavoo.dao;

import com.mycompany.sistemabuscavoo.model.BuscaVoo;
import com.mycompany.sistemabuscavoo.model.Voo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author mathe
 */


public class JpaDAO<T extends BuscaVoo> implements DAO<T> {
    private final EntityManager em;
    private final Class<T> classe;

    public JpaDAO(EntityManager em, Class<T> classe){
        this.em = em;
        this.classe = classe;
    }

    @Override
    public T findById(long id) {
        return em.find(classe, id);
    }

    @Override
    public boolean delete(T entity) {
        em.remove(entity);
        return true;
    }

    @Override
    public boolean delete(long id) {
        T entity = findById(id);
        return delete(entity);
    }

    @Override
    public long save(T entity) {
        if(entity.getId() > 0)
            em.merge(entity);
        else em.persist(entity);

        return entity.getId();
    }

    @Override
    public T findByField(String fieldName, Object value) {
        final String jpql = "select o from " + classe.getSimpleName() + " o " +
                            " where o." + fieldName + " = :" + fieldName;
        TypedQuery<T> query = em.createQuery(jpql, classe);
        query.setParameter(fieldName, value);
        return query.getSingleResult();
    }
    @Override
    public List<T> findByOriginDestination(String origin, String destination) {
        final String jpql = "select v from Voo v " +
                " where v.cidadeOrigem.nome = ?1 and v.cidadeDestino.nome = ?2";
        TypedQuery<T> query = em.createQuery(jpql, classe);
        
        return query.setParameter(1, origin).setParameter(2, destination).getResultList();
    }

    @Override
    public List<T> findByOriginDestinationDateStart(String origin, String destination, String date) {
                final String jpql = "select v from Voo v " +
                " where v.cidadeOrigem.nome = ?1 and v.cidadeDestino.nome = ?2 and v.dataPartida = ?3";
        TypedQuery<T> query = em.createQuery(jpql, classe);
        
        return  query.setParameter(1, origin).setParameter(2, destination).setParameter(3, date).getResultList();
    }

    @Override
    public List<T> findByOriginDestinationDateStartPrice(String origin, String destination, String date, double price) {
                        final String jpql = "select v from Voo v " +
                " where v.cidadeOrigem.nome = ?1 and v.cidadeDestino.nome = ?2 and v.dataPartida = ?3 and v.precoBilhete = ?4";
        TypedQuery<T> query = em.createQuery(jpql, classe);
        
        return  query.setParameter(1, origin).setParameter(2, destination).setParameter(3, date).setParameter(4, price).getResultList();
    }
}

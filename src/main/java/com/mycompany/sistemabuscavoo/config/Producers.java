/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabuscavoo.config;
import com.mycompany.sistemabuscavoo.dao.DAO;
import com.mycompany.sistemabuscavoo.dao.JpaDAO;
import com.mycompany.sistemabuscavoo.model.BuscaVoo;
import java.lang.reflect.ParameterizedType;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Producers {
    @Produces
    @PersistenceContext
    private EntityManager em;
    
    @Produces
    public <T extends BuscaVoo> DAO<T> getDao(InjectionPoint ip){
        ParameterizedType t = (ParameterizedType) ip.getType();
        Class classe = (Class) t.getActualTypeArguments()[0];
        return new JpaDAO(em, classe);
    }
}
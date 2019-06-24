/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabuscavoo.dao;
import com.mycompany.sistemabuscavoo.model.BuscaVoo;
import com.mycompany.sistemabuscavoo.model.Voo;
import java.util.List;
/**
 *
 * @author mathe
 */
public interface DAO<T extends BuscaVoo> {
    T findById(long id);
    T findByField(String fieldName, Object value);
    List<T> findByOriginDestination(String origin, String destination);
    boolean delete(T entity);
    boolean delete(long id);
    long save(T entity);
    List<T> findByOriginDestinationDateStart(String origin, String destination, String date);
    List<T> findByOriginDestinationDateStartPrice(String origin, String destination, String date, double price);
}

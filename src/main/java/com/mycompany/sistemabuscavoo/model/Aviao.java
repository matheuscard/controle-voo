/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabuscavoo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 *
 * @author mathe
 */
@Entity
public class Aviao implements BuscaVoo, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long capacidade;
    @OneToMany(fetch = FetchType.EAGER)
    List<Voo> voo = new ArrayList<>();
    
    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the capacidade
     */
    public long getCapacidade() {
        return capacidade;
    }

    /**
     * @param capacidade the capacidade to set
     */
    public void setCapacidade(long capacidade) {
        this.capacidade = capacidade;
    }

    public List<Voo> getVoo() {
        return voo;
    }

    public void setVoo(List<Voo> voo) {
        this.voo = voo;
    }

    
}

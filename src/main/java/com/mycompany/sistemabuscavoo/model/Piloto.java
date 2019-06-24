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
public class Piloto implements BuscaVoo, Serializable{    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cht;
    @OneToMany(fetch=FetchType.EAGER)
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cht
     */
    public String getCht() {
        return cht;
    }

    /**
     * @param cht the cht to set
     */
    public void setCht(String cht) {
        this.cht = cht;
    }

    public List<Voo> getVoo() {
        return voo;
    }

    public void setVoo(List<Voo> voo) {
        this.voo = voo;
    }
    
}

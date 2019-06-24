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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author mathe
 */
@Entity
public class Voo implements BuscaVoo, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Cidade cidadeOrigem;
    @ManyToOne
    private Cidade cidadeDestino;
    private String dataPartida;
    private String dataChegada;
    private String horaPartida;
    private String horaChegada;
    private double precoBilhete;
    @ManyToOne
    private Aviao aviao;
    @ManyToOne
    private Piloto piloto;
    @ManyToOne
    private Companhia companhia;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Reserva> reserva = new ArrayList<>();

        
    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the cidadeOrigem
     */
    public Cidade getCidadeOrigem() {
        return cidadeOrigem;
    }

    /**
     * @param cidadeOrigem the cidadeOrigem to set
     */
    public void setCidadeOrigem(Cidade cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    /**
     * @return the cidadeDestino
     */
    public Cidade getCidadeDestino() {
        return cidadeDestino;
    }

    /**
     * @param cidadeDestino the cidadeDestino to set
     */
    public void setCidadeDestino(Cidade cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    /**
     * @return the dataHoraPartida
     */
    public String getDataPartida() {
        return dataPartida;
    }

    /**
     * @param dataPartida the dataHoraPartida to set
     */
    public void setDataPartida(String dataPartida) {
        this.dataPartida = dataPartida;
    }

    /**
     * @return the dataHoraChegada
     */
    public String getDataChegada() {
        return dataChegada;
    }

    /**
     * @param dataChegada the dataHoraChegada to set
     */
    public void setDataChegada(String dataChegada) {
        this.dataChegada = dataChegada;
    }

    /**
     * @return the precoBilhete
     */
    public double getPrecoBilhete() {
        return precoBilhete;
    }

    /**
     * @param precoBilhete the precoBilhete to set
     */
    public void setPrecoBilhete(double precoBilhete) {
        this.precoBilhete = precoBilhete;
    }

    /**
     * @return the aviao
     */
    public Aviao getAviao() {
        return aviao;
    }

    /**
     * @param aviao the aviao to set
     */
    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    /**
     * @return the piloto
     */
    public Piloto getPiloto() {
        return piloto;
    }

    /**
     * @param piloto the piloto to set
     */
    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    /**
     * @return the companhia
     */
    public Companhia getCompanhia() {
        return companhia;
    }

    /**
     * @param companhia the companhia to set
     */
    public void setCompanhia(Companhia companhia) {
        this.companhia = companhia;
    }

    public String getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(String horaPartida) {
        this.horaPartida = horaPartida;
    }

    public String getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(String horaChegada) {
        this.horaChegada = horaChegada;
    }
        
    public List<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reserva = reserva;
    }

    
}

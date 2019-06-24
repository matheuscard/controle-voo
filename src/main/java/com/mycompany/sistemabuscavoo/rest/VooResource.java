/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemabuscavoo.rest;

import com.mycompany.sistemabuscavoo.dao.DAO;
import com.mycompany.sistemabuscavoo.model.Voo;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author mathe
 */

@Path("/voo")
@Transactional
public class VooResource {

    @Inject
    private DAO<Voo> dao;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Voo findById(@PathParam("id") long id) {
        return dao.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public long insert(Voo voo) {
        return dao.save(voo);
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean update(Voo voo) {
        //Se retornou um id maior que 0, é porque voo foi salvo no BD
        return dao.save(voo) > 0;
    }

    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") long id) {
        return dao.delete(id);
    }
    
    @GET
    @Path("{origin}/{destination}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Voo> findByOriginDestination(@PathParam("origin") String origin,
            @PathParam("destination") String destination){
        return dao.findByOriginDestination(origin, destination);
    }
    @GET
    @Path("{origin}/{destination}/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Voo> findByOriginDestinationDateStart(@PathParam("origin") String origin,
            @PathParam("destination") String destination,@PathParam("date") String date){
        return dao.findByOriginDestinationDateStart(origin, destination,date);
    }
    @GET
    @Path("{origin}/{destination}/{date}/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Voo> findByOriginDestinationDateStartPrice(@PathParam("origin") String origin,
            @PathParam("destination") String destination,@PathParam("date") String date, @PathParam("price") double price){
        return dao.findByOriginDestinationDateStartPrice(origin, destination,date, price);
    }
}

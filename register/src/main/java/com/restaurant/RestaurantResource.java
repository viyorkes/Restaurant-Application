package com.restaurant;


import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path(value = "/restaurant")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestaurantResource {

    @GET
    public List<Restaurant> hello() {
            return Restaurant.listAll();
    }



    @POST
    @Transactional
    @APIResponse(responseCode = "201", description = "Caso restaurante seja cadastrado com sucesso")
    public void add(Restaurant dto) {
        dto.persist();


    }

    @PUT
    @Path("{id}")
    @Transactional
    public void update(@PathParam("id") Long id, Restaurant dto) {
        Optional<Restaurant> restaurantResponse = Restaurant.findByIdOptional(id);

        if(restaurantResponse.isEmpty())
        {
            throw new NotFoundException();
        }

       Restaurant restaurant = restaurantResponse.get();
        restaurant.name =dto.name;
        dto.persist();


    }



    @DELETE
    @Path("{id}")
    @Transactional
    public void delete(@PathParam("id") Long id, Restaurant dto) {
        Optional<Restaurant> restaurantResponse = Restaurant.findByIdOptional(id);

        restaurantResponse.ifPresentOrElse(Restaurant::delete,() ->{
            throw new NotFoundException();

        });


    }



}

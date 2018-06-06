package com.jwt.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


/**
 * The jax-rs service, deployable to GlassFish, which tracks food.
 * 
 * @author taylor
 *
 */
@Path("/foods")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })

public class FoodRestService {
	@Context
	private UriInfo uriInfo;


	/**
	 * Get a food.
	 * 
	 * @param name
	 *            the food to get.
	 * @return the status and food.
	 */
	@GET
	@Path("{name}")
	public Response get(@PathParam("name") String name) {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		return Response.noContent().build();	
	}



}

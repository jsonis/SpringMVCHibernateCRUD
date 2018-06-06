package com.jwt.rest;

import java.io.IOException;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jwt.model.MedicalResearchProgram;
import com.jwt.service.MPService;

/**
 * @author jsonis
 * 
 * restful web service class prepared out 
 * uses jersey jar(jersery-bundle-1.19.1.jar jersey-spring-1.19.1.jar)
 * 
 * sqlClient is loaded using Autowiring 
 */

@Component
@Path("/evsService")
public class EvsWsService {
	

	private static final transient Logger log = Logger.getLogger(EvsWsService.class.getName());
	
	@Autowired
	private MPService mpService;
		

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_XML)
	public Response getEvsWeeklyWSService(@PathParam("token") String token){
			log.debug("XXXXX Inside WEEKLY webService");
			return Response.status(200).entity("Hello").build();
	}
	
	@GET
	@Path("/getparticipant/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response listParticipantInfo(@PathParam("id") String id) throws IOException {
		MedicalResearchProgram program = mpService.getProgram(new Integer(id).intValue());
		return Response.status(200).entity(program).build();
	}
}

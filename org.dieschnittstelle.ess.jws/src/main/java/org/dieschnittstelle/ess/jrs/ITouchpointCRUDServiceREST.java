package org.dieschnittstelle.ess.jrs;

import java.util.List;

import org.dieschnittstelle.ess.entities.crm.StationaryTouchpoint;

import javax.ws.rs.*;

@Path("/touchpoints")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public interface ITouchpointCRUDServiceREST {
	
	@GET
	public List<StationaryTouchpoint> readAllTouchpoints();
	
	@POST
	public StationaryTouchpoint createTouchpoint(StationaryTouchpoint touchpoint); 
	
	@DELETE
	@Path("/{touchpointId}")
	public boolean deleteTouchpoint(@PathParam("touchpointId") long id); 
	
	@GET
	@Path("/{touchpointId}")
	public StationaryTouchpoint readTouchpoint(@PathParam("touchpointId") long id);
	
	/*
	 * UE JRS: add a new annotated method for using the updateTouchpoint functionality of TouchpointCRUDExecutor and implement it
	 */
	@PUT
	@Path("/{touchpointId}")
	StationaryTouchpoint updateTouchpoint(@PathParam("touchpointId") long id, StationaryTouchpoint touchpoint);
}

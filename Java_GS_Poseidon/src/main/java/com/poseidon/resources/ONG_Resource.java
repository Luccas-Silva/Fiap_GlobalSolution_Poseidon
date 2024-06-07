package com.poseidon.resources;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.poseidon.bo.ONG_BO;
import com.poseidon.model.ONG;

@Path("/ong")
public class ONG_Resource {
	
	private ONG_BO ong_BO = new ONG_BO();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs(ONG ong, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException, Exception {
		ong_BO.InsertBO(ong);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder(); 
		builder.path(Integer.toString(ong.getId_ONG())); 
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{Id_ONG}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs(ONG ong, @PathParam("Id_ONG") Integer Id_ONG) throws ClassNotFoundException, SQLException {
		ong_BO.UpdateBO(ong);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{Id_ONG}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("Id_ONG") Integer Id_ONG) throws ClassNotFoundException, SQLException {
		ong_BO.DeleteBO(Id_ONG);
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ONG> selecionarRs() throws ClassNotFoundException, SQLException{
		return (ArrayList<ONG>) ong_BO.SelectBO();
	}

}

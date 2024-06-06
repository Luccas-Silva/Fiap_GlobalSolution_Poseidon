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

import com.poseidon.bo.DenunciaBO;
import com.poseidon.model.Denuncia;

@Path("/denuncia")
public class DenunciaResource {
	
	private DenunciaBO denunciaBO = new DenunciaBO();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs(Denuncia denuncia, @Context UriInfo uriInfo) throws Exception, ClassNotFoundException, SQLException {
		denunciaBO.InsertBO(denuncia);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder(); 
		builder.path(Integer.toString(denuncia.getId_Denuncia())); 
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{Id_Denuncia}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs(Denuncia denuncia, @PathParam("Id_Denuncia") Integer Id_Denuncia) throws ClassNotFoundException, SQLException {
		denunciaBO.UpdateBO(denuncia);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{Id_Denuncia}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("Id_Denuncia") Integer Id_Denuncia) throws ClassNotFoundException, SQLException {
		denunciaBO.DeleteBO(Id_Denuncia);
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Denuncia> selecionarRs() throws ClassNotFoundException, SQLException{
		return (ArrayList<Denuncia>) denunciaBO.SelectBO();
	}

}

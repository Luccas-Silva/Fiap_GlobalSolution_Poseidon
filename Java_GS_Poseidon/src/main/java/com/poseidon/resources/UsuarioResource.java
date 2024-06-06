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

import com.poseidon.bo.UsuarioBO;
import com.poseidon.model.Usuario;

@Path("/usuario")
public class UsuarioResource {
	
	private UsuarioBO usuarioBO = new UsuarioBO();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs(Usuario usuario, @Context UriInfo uriInfo) throws Exception, ClassNotFoundException, SQLException {
		usuarioBO.InsertBO(usuario);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder(); 
		builder.path(Integer.toString(usuario.getId_Usuario())); 
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{Id_Usuario}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs(Usuario usuario, @PathParam("Id_Usuario") Integer Id_Usuario) throws ClassNotFoundException, SQLException {
		usuarioBO.UpdateBO(usuario);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{Id_Usuario}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("Id_Usuario") Integer Id_Usuario) throws ClassNotFoundException, SQLException {
		usuarioBO.DeleteBO(Id_Usuario);
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Usuario> selecionarRs() throws ClassNotFoundException, SQLException{
		return (ArrayList<Usuario>) usuarioBO.SelectBO();
	}

}

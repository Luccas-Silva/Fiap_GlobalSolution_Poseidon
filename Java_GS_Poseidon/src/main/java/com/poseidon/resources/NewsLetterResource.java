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

import com.poseidon.bo.NewsLetterBO;
import com.poseidon.model.NewsLetter;

@Path("/newsletter")
public class NewsLetterResource {
	
	private NewsLetterBO newsletterBO = new NewsLetterBO();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs(NewsLetter newsletter, @Context UriInfo uriInfo) throws Exception, ClassNotFoundException, SQLException {
		newsletterBO.InsertBO(newsletter);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder(); 
		builder.path(Integer.toString(newsletter.getId_NewsLetter())); 
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{Id_NewsLetter}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs(NewsLetter newsletter, @PathParam("Id_NewsLetter") Integer Id_NewsLetter) throws ClassNotFoundException, SQLException {
		newsletterBO.UpdateBO(newsletter);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{Id_NewsLetter}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("Id_NewsLetter") Integer Id_NewsLetter) throws ClassNotFoundException, SQLException {
		newsletterBO.DeleteBO(Id_NewsLetter);
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<NewsLetter> selecionarRs() throws ClassNotFoundException, SQLException{
		return (ArrayList<NewsLetter>) newsletterBO.SelectBO();
	}

}

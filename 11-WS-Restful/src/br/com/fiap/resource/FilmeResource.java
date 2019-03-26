package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
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

import br.com.fiap.dao.FilmeDAO;
import br.com.fiap.dao.impl.FilmeDAOImpl;
import br.com.fiap.entity.Filme;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@Path("/filme")
public class FilmeResource {

	private FilmeDAO dao;

	public FilmeResource() {
		dao = new FilmeDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}

	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int codigo) {
		try {
			dao.remover(codigo);
			dao.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new InternalServerErrorException(); //Erro 500
		}
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Filme filme, @PathParam("id") int codigo) {
		try {
			filme.setCodigo(codigo);
			dao.atualizar(filme);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		return Response.ok().build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Filme buscar(@PathParam("id") int codigo) {
		return dao.buscar(codigo);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Filme filme, @Context UriInfo uri) {
		try {
			dao.cadastrar(filme);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build(); // Erro 500
		}
		// Criar a URL para acessar o recurso (filme) cadastrado
		UriBuilder url = uri.getAbsolutePathBuilder();
		// Adiciona na URL o código do filme cadastrado
		url.path(Integer.toString(filme.getCodigo()));
		// Retorna o código 201 Created e a URL para o filme cadastrado
		return Response.created(url.build()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Filme> buscar() {
		return dao.listar();
	}

}

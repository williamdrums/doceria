package br.com.doceria.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.doceria.as.UsuarioAS;
import br.com.doceria.entity.Usuario;

@Path("/usuario")
public class UsuarioResource {

    UsuarioAS usuarioAS = new UsuarioAS();

    @POST
    @Path("/salvar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(Usuario usuario) {

        try {
            usuarioAS.salvar(usuario);
        } catch (Exception e) {
            System.out.println("Erro ao Salvar Usuario" + Response.status(500));
        }
        return Response.status(201).entity(usuario).build();
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
        return Response.status(200).entity(usuarioAS.listar()).build();
    }

    @PUT
    @Path("/editar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@PathParam("id") Integer id, Usuario usuario) {
        usuario.setId(id);
        return Response.ok(200).entity(usuarioAS.editar(usuario)).build();
    }

    @DELETE
    @Path("/excluir/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response excluir(@PathParam("id") Integer id) {
        usuarioAS.excluir(id);
        return Response.ok(200).build();
    }

}

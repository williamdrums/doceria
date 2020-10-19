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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.LogManager;

@Path("/usuario")
public class UsuarioResource {
private static final Logger logger = LoggerFactory.getLogger(UsuarioResource.class);

    UsuarioAS usuarioAS = new UsuarioAS();

    @POST
    @Path("/salvar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveUser(Usuario usuario) {

        logger.info("Iniciando  Aplicação");
        try {
            usuarioAS.save(usuario);
            return Response.status(201).entity(usuario).build();
        } catch (Exception e) {
            Response.status(500);
            logger.error("Erro ao tentar salvar usuario"+e);
            return Response.accepted().build();
        }
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllUsers() {
        logger.info("Iniciando Listagem de Usuarios Cadastrados");
        return Response.status(200).entity(usuarioAS.findAll()).build();
    }

    @PUT
    @Path("/editar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") Integer id, Usuario usuario) {

        usuario.setId(id);
        logger.info("Atulizando Usuario "+usuario.getNome());
        return Response.ok(200).entity(usuarioAS.update(usuario)).build();
    }

    @DELETE
    @Path("/excluir/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id") Integer id) {
        logger.info("Excluindo Usuario");
        usuarioAS.delete(id);
        return Response.ok(200).build();
    }

}

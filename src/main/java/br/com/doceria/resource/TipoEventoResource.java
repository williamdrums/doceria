package br.com.doceria.resource;

import br.com.doceria.as.TipoEventoAS;
import br.com.doceria.entity.TipoEvento;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/tipoevento")
public class TipoEventoResource {

    TipoEventoAS tipoEventoAS = new TipoEventoAS();


    @POST
    @Path("/salvar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvaTipoEvento(TipoEvento tipoEvento) {

        try {
            tipoEventoAS.save(tipoEvento);
        } catch (Exception exception) {
            System.out.println("Erro ao Salvar TipoEvento" + Response.status(500) + "/n" + exception.getMessage());
        }
        return Response.status(201).build();
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTipoEvento() {
        return Response.status(200).entity(tipoEventoAS.findAll()).build();
    }

    @PUT
    @Path("/editar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editarTipoEvento(@PathParam("id") Integer id, TipoEvento tipoEvento) {
        tipoEvento.setId(id);
        return Response.ok().entity(tipoEventoAS.update(tipoEvento)).build();
    }

    @DELETE
    @Path("/excluir/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response excluirTipoEvento(@PathParam("id") Integer id) {
        tipoEventoAS.delete(id);
        return Response.ok(200).build();
    }

}

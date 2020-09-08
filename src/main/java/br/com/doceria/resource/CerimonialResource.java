package br.com.doceria.resource;

import br.com.doceria.as.CerimonialAS;
import br.com.doceria.entity.Cerimonial;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cerimonial")
public class CerimonialResource {

    CerimonialAS cerimonialAS = new CerimonialAS();

    @POST
    @Path("/salvar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvaCerimonial(Cerimonial cerimonial) {

        try {
            cerimonialAS.save(cerimonial);
        } catch (Exception exception) {
            Response.status(500);
            System.out.println("Erro ao Salvar TipoEvento" + "/n" + exception.getMessage());
        }
        return Response.status(201).build();
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarCerimonial() {
        return Response.status(200).entity(cerimonialAS.findAll()).build();
    }

    @PUT
    @Path("/editar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editarCerimonial(@PathParam("id") Integer id, Cerimonial cerimonial) {
        cerimonial.setId(id);
        return Response.ok().entity(cerimonialAS.update(cerimonial)).build();
    }

    @DELETE
    @Path("/excluir/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response excluirCerimonial(@PathParam("id") Integer id) {
        cerimonialAS.delete(id);
        return Response.ok(200).build();
    }
}

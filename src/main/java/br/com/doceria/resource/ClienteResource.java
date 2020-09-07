package br.com.doceria.resource;

import br.com.doceria.as.ClienteAS;
import br.com.doceria.entity.Cliente;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cliente")
public class ClienteResource {

    ClienteAS clienteAS = new ClienteAS();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(Cliente cliente) {

        try {
            clienteAS.salvar(cliente);
        } catch (Exception e) {
            System.out.println("Erro ao Salvar Cliente" + Response.status(500));
        }
        return Response.status(201).entity(cliente).build();
    }

    @GET
    @Path("/listar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response listar() {
        clienteAS.listar();
        return Response.status(200).entity(clienteAS.listar()).build();
    }

    @PUT
    @Path("editar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@PathParam("id") Integer id, Cliente cliente) {
        cliente.setId(id);
        clienteAS.editar(cliente);
        return Response.ok(200).build();
    }

    @DELETE
    @Path("excluir/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response excluir(@PathParam("id") Integer id) {
        clienteAS.excluir(id);
        return Response.ok(200).build();
    }
}

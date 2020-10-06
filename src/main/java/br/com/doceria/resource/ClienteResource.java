package br.com.doceria.resource;

import br.com.doceria.as.ClienteAS;
import br.com.doceria.entity.Cliente;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cliente")
public class ClienteResource {

    ClienteAS clienteAS = new ClienteAS();

    @POST
    @Path("/salvar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveClient(Cliente cliente) {

        try {
            clienteAS.save(cliente);
        } catch (Exception e) {
            System.out.println("Erro ao Salvar Cliente" + Response.status(500));
        }
        return Response.status(201).entity(cliente).build();
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllClient() {
        return Response.status(200).entity(clienteAS.findAll()).build();
    }

    @PUT
    @Path("editar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateClient(@PathParam("id") Integer id, Cliente cliente) {
        cliente.setId(id);
        clienteAS.update(cliente);
        return Response.ok(200).build();
    }

    @DELETE
    @Path("excluir/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteClient(@PathParam("id") Integer id) {
        clienteAS.delete(id);
        return Response.ok(200).build();
    }
}

package br.com.doceria.resource;

import br.com.doceria.as.ProdutoAS;
import br.com.doceria.entity.Produto;

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

@Path("/produto")
public class ProdutoResource {

    ProdutoAS produtoAS = new ProdutoAS();

    @POST
    @Path("/salvar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response productSaveResource(Produto produto) {
        Response response = null;
        try {
            produtoAS.save(produto);
            response = Response.status(201).build();
        } catch (Exception exception) {
            System.out.println("Não foi possivel salvar o produto" + 500);
        }
        return response;
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response productFindAllResource() {
        return Response.status(200).entity(produtoAS.findAll()).build(); }

    @PUT
    @Path("/atualiza/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response productUpdateResource(@PathParam("id") Integer id, Produto produto) {

        produto.setId(id);
        return Response.status(200).entity(produtoAS.update(produto)).build();
    }

    @DELETE
    @Path("/excluir/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response productDeleteResource(@PathParam("id") Integer id) {
        produtoAS.delete(id);
        return Response.ok(200).build();

    }
}

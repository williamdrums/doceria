//package br.com.doceria.resource;
//
//import br.com.doceria.as.ItemPedidoAS;
//import br.com.doceria.entity.ItemPedido;
//
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//@Path("/itempedido")
//public class ItemPedidoResource {
//
//    ItemPedidoAS itemPedidoAS = new ItemPedidoAS();
//
//    @POST
//    @Path("/salvar")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response save(ItemPedido itemPedido) {
//        try {
//            itemPedidoAS.save(itemPedido);
//            return Response.status(201).entity(itemPedido).build();
//        } catch (Exception ex) {
//            System.out.println("Erro ao Salvar ItemPedido" + ex.getMessage());
//            return Response.serverError().build();
//        }
//    }
//
//    @GET
//    @Path("/listar")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response findAll() {
//        return Response.status(200).entity(itemPedidoAS.findAll()).build();
//    }
//
//    @PUT
//    @Path("/editar/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response update(@PathParam("id") Integer id, ItemPedido itemPedido) {
//        itemPedido.setId(id);
//        try {
//            itemPedidoAS.update(itemPedido);
//        } catch (Exception e) {
//            System.out.println("Erro ao Atulizar ItenPedido" + e);
//        }
//        return Response.ok(204).build();
//    }
//
//    @DELETE
//    @Path("/excluir/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response delete(@PathParam("id") Integer id) {
//
//        try {
//            itemPedidoAS.delete(id);
//            return Response.ok(200).build();
//        } catch (Exception e) {
//            return Response.ok(404).build();
//        }
//    }
//}

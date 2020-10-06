//package br.com.doceria.as;
//
//import br.com.doceria.dao.ItemPedidoDAO;
//import br.com.doceria.entity.ItemPedido;
//import br.com.doceria.util.JPAUtil;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//public class ItemPedidoAS {
//
//    EntityManager manager = new JPAUtil().getEntityManager();
//    private ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO(manager);
//
//    public ItemPedidoAS() {
//    }
//
//    public void save(ItemPedido itemPedido) {
//        try {
//            itemPedidoDAO.save(itemPedido);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    public List<ItemPedido> findAll() {
//        return itemPedidoDAO.findAll();
//    }
//
//    public void delete(int id) {
//        itemPedidoDAO.delete(id);
//    }
//
//    public ItemPedido update(ItemPedido itemPedido) {
//        ItemPedido item = itemPedidoDAO.findById(itemPedido.getId());
//
//        item.setIdProduto(itemPedido.getIdProduto());
//        item.setQuantidade(itemPedido.getQuantidade());
//        item.setValorItem(itemPedido.getValorItem());
//
//        ItemPedido novoItem = itemPedidoDAO.update(item);
//
//        return novoItem;
//    }
//}

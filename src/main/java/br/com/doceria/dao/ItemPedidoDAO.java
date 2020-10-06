//package br.com.doceria.dao;
//
//import br.com.doceria.entity.ItemPedido;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Query;
//import java.util.List;
//
//public class ItemPedidoDAO {
//    EntityManager manager;
//
//
//    public ItemPedidoDAO(EntityManager manager) {
//        this.manager = manager;
//    }
//
//    public ItemPedido save(ItemPedido itemPedido) {
//
//        EntityTransaction tx = manager.getTransaction();
//
//        try {
//            tx.begin();
//            manager.persist(itemPedido);
//            manager.flush();
//            tx.commit();
//        } catch (Exception exception) {
//            tx.rollback();
//        }
//        return itemPedido;
//    }
//
//    public ItemPedido findById(int id) {
//        return manager.find(ItemPedido.class, id);
//    }
//
//    public List<ItemPedido> findAll() {
//        Query query = manager.createNamedQuery("ItemPedido.FindAll");
//        return query.getResultList();
//    }
//
//    public ItemPedido update(ItemPedido itemPedido) {
//        ItemPedido novoItem = null;
//        EntityTransaction tx = manager.getTransaction();
//        try {
//            tx.begin();
//            novoItem = manager.merge(itemPedido);
//            tx.commit();
//        } catch (Exception e) {
//            System.out.println("Erro ao Atualizar:" + e);
//        }
//        return novoItem;
//    }
//
//    public void delete(int id) {
//
//        EntityTransaction tx = manager.getTransaction();
//        ItemPedido itemPedido = manager.find(ItemPedido.class, id);
//        try {
//            tx.begin();
//            manager.remove(itemPedido);
//            tx.commit();
//        } catch (Exception e) {
//
//            tx.rollback();
//            e.printStackTrace();
//        }
//    }
//
//}

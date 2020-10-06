
package br.com.doceria.dao;

import br.com.doceria.entity.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class ClienteDAO {

    private EntityManager manager;

    public ClienteDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void save(Cliente cliente) {
        EntityTransaction tx = manager.getTransaction();
        try {
            if (cliente.getId() == null) {
                tx.begin();
                manager.persist(cliente);
                tx.commit();
            }
        } catch (Exception e) {
            System.out.println("Não foi possivel salvar Cliente:" + e.getMessage());

        }
    }

    public Cliente findById(Integer id) {
        Cliente cliente = manager.find(Cliente.class, id);
        return cliente;
    }

    public Cliente update(Cliente cliente) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Cliente clienteAtualizado = manager.merge(cliente);
        tx.commit();
        return clienteAtualizado;
    }

    public void delete(Integer id) {
        EntityTransaction tx = manager.getTransaction();
        Cliente cliente = manager.find(Cliente.class, id);
        try {
            tx.begin();
            manager.remove(cliente);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Cliente> findAll() {
        Query consulta = manager.createNamedQuery("Cliente.FindAll");
        return consulta.getResultList();
    }
}

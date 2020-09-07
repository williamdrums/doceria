package br.com.doceria.dao;

import br.com.doceria.entity.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class ProdutoDAO {

    private EntityManager manager;

    public ProdutoDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void save(Produto produto) {

        EntityTransaction tx = manager.getTransaction();

        try {
            if (produto.getId() == null) {
                tx.begin();
                manager.persist(produto);
                tx.commit();
            }
        } catch (Exception exception) {
            System.out.println("Erro ao salvar produto:" + exception.getMessage());
        }
    }

    public List<Produto> findAll() {
        Query consulta = manager.createNamedQuery("Produto.FindAll");
        return consulta.getResultList();
    }

    public Produto findById(Integer id) {
        return manager.find(Produto.class, id);
    }

    public Produto update(Produto produto) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Produto produtoUpdate = manager.merge(produto);
        tx.commit();
        return produto;
    }

    public void delete(Integer id) {
        EntityTransaction tx = manager.getTransaction();
        Produto produto = manager.find(Produto.class, id);
        try {
            tx.begin();
            manager.remove(produto);
            tx.commit();
        } catch (Exception exception) {
            tx.rollback();
            System.out.println("Nao foi possivel excluir o produto" + exception.getMessage());
        }
    }
}

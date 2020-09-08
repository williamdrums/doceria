package br.com.doceria.dao;

import br.com.doceria.entity.Cerimonial;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;


public class CerimonialDAO {

    private EntityManager manager;

    public CerimonialDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void save(Cerimonial cerimonial) {

        EntityTransaction tx = manager.getTransaction();
        try {
            if (cerimonial.getId() == null) {
                tx.begin();
                manager.persist(cerimonial);
                tx.commit();
            }
        } catch (Exception exception) {
            System.out.println("Não foi possivel salvar cerimonial" + exception.getMessage());
        }
    }

    public List<Cerimonial> findAll() {
        Query query = manager.createNamedQuery("Cerimonial.FindAll");
        return query.getResultList();
    }

    public Cerimonial findById(Integer id) {
        return manager.find(Cerimonial.class, id);
    }

    public Cerimonial update(Cerimonial cerimonial) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Cerimonial cerimonialUpdate = manager.merge(cerimonial);
        tx.commit();
        return cerimonialUpdate;
    }

    public void delete(Integer id) {

        Cerimonial cerimonial = this.findById(id);
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            manager.remove(cerimonial);
            tx.commit();
        } catch (Exception exception) {
            tx.rollback();
            exception.printStackTrace();
        }
    }

}

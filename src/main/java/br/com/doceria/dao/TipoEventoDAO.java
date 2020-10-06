package br.com.doceria.dao;

import br.com.doceria.entity.TipoEvento;
import br.com.doceria.entity.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class TipoEventoDAO {

    private EntityManager manager;

    public TipoEventoDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void save(TipoEvento tipoEvento) {

        EntityTransaction tx = manager.getTransaction();
        try {
            if (tipoEvento.getId() == null) {
                tx.begin();
                manager.persist(tipoEvento);
                tx.commit();
            }
        } catch (Exception e) {
            System.out.println("Não foi Possivel Salvar o TipoEvento" + e.getMessage());
        }
    }

    public List<TipoEvento> findAll() {
        Query query = manager.createNamedQuery("TipoEvento.FindAll");
        return query.getResultList();
    }

    public TipoEvento update(TipoEvento tipoEvento) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        TipoEvento tipoEventoUpdate = manager.merge(tipoEvento);
        tx.commit();
        return tipoEventoUpdate;
    }
    public TipoEvento findById(Integer id) {
        return manager.find(TipoEvento.class, id);
    }

    public void delete(Integer id) {
        EntityTransaction tx = manager.getTransaction();
        TipoEvento tipoEvento = manager.find(TipoEvento.class, id);
        try {
            tx.begin();
            manager.remove(tipoEvento);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}

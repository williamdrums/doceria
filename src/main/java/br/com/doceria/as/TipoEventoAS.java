package br.com.doceria.as;

import br.com.doceria.dao.TipoEventoDAO;
import br.com.doceria.entity.TipoEvento;
import br.com.doceria.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class TipoEventoAS {

    EntityManager manager = new JPAUtil().getEntityManager();
    TipoEventoDAO tipoEventoDAO = new TipoEventoDAO(manager);

    public TipoEventoAS() {

    }

    public void save(TipoEvento tipoEvento) {

        try {
            tipoEventoDAO.save(tipoEvento);
        } catch (Exception ex) {
            System.out.println(500 + "Erro ao salvar TipoEvento");
        }
    }

    public TipoEvento update(TipoEvento tipoEvento) {
        TipoEvento tipoEventoUpdate = tipoEventoDAO.findById(tipoEvento.getId());

        tipoEventoUpdate.setDescricao(tipoEvento.getDescricao());
        TipoEvento tipoEventoNovo = tipoEventoDAO.update(tipoEventoUpdate);

        return tipoEventoNovo;
    }

    public void delete(Integer id) {
        try {
            tipoEventoDAO.delete(id);
        } catch (Exception e) {
            System.out.println("Erro ao tentar excluir TipoEvento");
        }
    }

    public List<TipoEvento> findAll() {
        return tipoEventoDAO.findAll();
    }

}

package br.com.doceria.as;

import br.com.doceria.dao.CerimonialDAO;
import br.com.doceria.entity.Cerimonial;
import br.com.doceria.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CerimonialAS {

    EntityManager manager = new JPAUtil().getEntityManager();
    CerimonialDAO cerimonialDAO = new CerimonialDAO(manager);

    public CerimonialAS() {

    }

    public void save(Cerimonial cerimonial) {
        try {
            cerimonialDAO.save(cerimonial);
        } catch (Exception exception) {
            System.out.println(500 + "Não foi possivel salvar cerimonial" + exception.getMessage());
        }
    }

    public List<Cerimonial> findAll() {
        return cerimonialDAO.findAll();
    }

    public Cerimonial update(Cerimonial cerimonial) {

        Cerimonial cerimonialUpdate = cerimonialDAO.findById(cerimonial.getId());
        cerimonialUpdate.setDecricao(cerimonial.getDecricao());
        return cerimonialUpdate;
    }

    public void delete(Integer id) {

        try {
            cerimonialDAO.delete(id);
        } catch (Exception exception) {
            System.out.println(500 + "Não foi possivel remover cerimonial" + exception.getMessage());
        }
    }
}

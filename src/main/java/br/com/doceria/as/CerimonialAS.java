package br.com.doceria.as;

import br.com.doceria.dao.CerimonialDAO;
import br.com.doceria.entity.Cerimonial;
import br.com.doceria.util.JPAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class CerimonialAS {

    private static final Logger logger = LoggerFactory.getLogger(CerimonialAS.class);


    EntityManager manager = new JPAUtil().getEntityManager();
    CerimonialDAO cerimonialDAO = new CerimonialDAO(manager);

    public CerimonialAS() {

    }

    public void save(Cerimonial cerimonial) {
        try {
            logger.info("Salvando Cerimonial:" + cerimonial.getDescricao());
            cerimonialDAO.save(cerimonial);
        } catch (Exception exception) {
            logger.error(500 + "Não foi possivel salvar cerimonial" + exception.getMessage());
        }
    }

    public List<Cerimonial> findAll() {
        logger.info("Buscando todos os Cerimoniais");
        return cerimonialDAO.findAll();
    }

    public Cerimonial update(Cerimonial cerimonial) {
        Cerimonial novoCerimonial = null;
        try {
            Cerimonial cerimonialUpdate = cerimonialDAO.findById(cerimonial.getId());
            cerimonialUpdate.setDescricao(cerimonial.getDescricao());
            novoCerimonial = cerimonialDAO.update(cerimonialUpdate);
        } catch (Exception ex) {
            logger.error("Erro ao salvar Cerimonial" + 500, ex.getMessage());
        }
        return novoCerimonial;
    }

    public void delete(Integer id) {

        try {
            logger.info("Deletando Cerimonial");
            cerimonialDAO.delete(id);
        } catch (Exception exception) {
            logger.error(500 + "Não foi possivel remover cerimonial" + exception.getMessage());
        }
    }
}

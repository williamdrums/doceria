package br.com.doceria.as;

import br.com.doceria.dao.TipoEventoDAO;
import br.com.doceria.entity.TipoEvento;
import br.com.doceria.util.JPAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class TipoEventoAS {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioAS.class);

    EntityManager manager = new JPAUtil().getEntityManager();
    TipoEventoDAO tipoEventoDAO = new TipoEventoDAO(manager);

    public TipoEventoAS() {

    }

    public void save(TipoEvento tipoEvento) {

        try {
            logger.info("Salvando Tipo Evento");
            tipoEventoDAO.save(tipoEvento);
        } catch (Exception ex) {
            logger.error(500 + "Erro ao salvar TipoEvento" + ex.getMessage());
        }
    }

    public TipoEvento update(TipoEvento tipoEvento) {
        TipoEvento tipoEventoNovo = null;
        try {
            logger.info("Atualizando Tipo Evento" + tipoEvento.getDescricao());
            TipoEvento tipoEventoUpdate = tipoEventoDAO.findById(tipoEvento.getId());

            tipoEventoUpdate.setDescricao(tipoEvento.getDescricao());
            tipoEventoNovo = tipoEventoDAO.update(tipoEventoUpdate);
        } catch (Exception ex) {
            logger.error("Erro ao Atualizar:" + tipoEvento.getDescricao());
        }
        return tipoEventoNovo;
    }

    public void delete(Integer id) {
        try {
            logger.info("Deletando Tipo Evento");
            tipoEventoDAO.delete(id);
        } catch (Exception e) {
            logger.error(500+"Erro ao tentar excluir TipoEvento");
        }
    }

    public List<TipoEvento> findAll() {
        logger.info("Buscando Todos Eventos");
        return tipoEventoDAO.findAll();
    }

}

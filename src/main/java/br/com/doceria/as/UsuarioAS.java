package br.com.doceria.as;

import java.util.List;


import javax.persistence.EntityManager;

import br.com.doceria.dao.UsuarioDAO;
import br.com.doceria.entity.Usuario;
import br.com.doceria.util.JPAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UsuarioAS {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioAS.class);

    EntityManager manager = new JPAUtil().getEntityManager();
    UsuarioDAO usuarioDAO = new UsuarioDAO(manager);

    public UsuarioAS() {
    }

    public void save(Usuario usuario) throws Exception {
        logger.info("Inserindo Dados do Usuario");
        try {
            usuarioDAO.save(usuario);
        } catch (Exception ex) {
            logger.error("Erro ao tentar salvar usuario" + ex.getMessage());

        }
    }

    public Usuario update(Usuario usuario) {
        Usuario usuarioRetorno = null;
        Usuario usuarioUpdate = usuarioDAO.findById(usuario.getId());

        logger.info("Atulizando Usuario" + usuarioUpdate.getNome());

        try {
            usuarioUpdate.setNome(usuario.getNome());
            usuarioUpdate.setEmail(usuario.getEmail());
            usuarioUpdate.setSenha(usuario.getSenha());
            usuarioRetorno = usuarioDAO.update(usuarioUpdate);

        } catch (Exception ex) {
            logger.error("Erro ao atualizar usuario" + ex.getMessage());
        }
        return usuarioRetorno;
    }

    public void delete(Integer id) {
        try {
            logger.info("Deletando Usuario");
            usuarioDAO.delete(id);
        } catch (Exception e) {
            logger.error("Erro ao tentar excluir usuario", e);
        }
    }

    public List<Usuario> findAll() {
        logger.info("Buscando Todos Usuario Cadastrados");
        return usuarioDAO.findAll();
    }
}

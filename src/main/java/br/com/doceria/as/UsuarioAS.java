package br.com.doceria.as;

import java.util.List;


import javax.persistence.EntityManager;

import br.com.doceria.dao.UsuarioDAO;
import br.com.doceria.entity.Usuario;
import br.com.doceria.util.JPAUtil;

public class UsuarioAS {

    EntityManager manager = new JPAUtil().getEntityManager();
    UsuarioDAO usuarioDAO = new UsuarioDAO(manager);

    public UsuarioAS() {
    }

    public void save(Usuario usuario) {

        try {
            usuarioDAO.save(usuario);
        } catch (Exception ex) {
            System.out.println(500 + "Erro ao salvar usuario"+ex.getMessage());
        }
    }

    public Usuario update(Usuario usuario) {
        Usuario usuarioUpdate = usuarioDAO.findById(usuario.getId());

        usuarioUpdate.setNome(usuario.getNome());
        usuarioUpdate.setEmail(usuario.getEmail());
        usuarioUpdate.setSenha(usuario.getSenha());
        Usuario usuarioRetorno = usuarioDAO.update(usuarioUpdate);

        return usuarioRetorno;
    }

    public void delete(Integer id) {
        try {
            usuarioDAO.delete(id);
        } catch (Exception e) {
            System.out.println("Erro ao tentar excluir usuario");
        }
    }

    public List<Usuario> findAll() {
        return usuarioDAO.findAll();
    }
}

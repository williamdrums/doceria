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

    public void salvar(Usuario usuario) {

        try {
            usuarioDAO.salvar(usuario);
        } catch (Exception ex) {
            System.out.println(500 + "Erro ao salvar usuario");
        }
    }

    public Usuario editar(Usuario usuario) {
        Usuario usuarioUpdate = usuarioDAO.buscarPorId(usuario.getId());

        usuarioUpdate.setNome(usuario.getNome());
        usuarioUpdate.setEmail(usuario.getEmail());
        usuarioUpdate.setSenha(usuario.getSenha());
        Usuario usuarioRetorno = usuarioDAO.editar(usuarioUpdate);

        return usuarioRetorno;
    }

    public void excluir(Integer id) {
        try {
            usuarioDAO.excluir(id);
        } catch (Exception e) {
            System.out.println("Erro ao tentar excluir usuario");
        }
    }

    public List<Usuario> listar() {
        return usuarioDAO.buscarTodos();
    }
}

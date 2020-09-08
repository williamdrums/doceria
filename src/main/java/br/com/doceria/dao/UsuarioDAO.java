package br.com.doceria.dao;

import br.com.doceria.entity.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class UsuarioDAO {

    private EntityManager manager;

    public UsuarioDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void salvar(Usuario usuario) {
        EntityTransaction tx = manager.getTransaction();
        try {
            if (usuario.getId() == null) {
                tx.begin();
                manager.persist(usuario);
                tx.commit();
            }
        } catch (Exception e) {

            System.out.println("Não foi Possivel Salvar Usuario" + e.getMessage());
        }
    }

    public Usuario editar(Usuario usuario) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Usuario usuarioSalvo = manager.merge(usuario);
        tx.commit();
        return usuarioSalvo;
    }

    public Usuario buscarPorId(Integer id) {
        return manager.find(Usuario.class, id);
    }

    public List<Usuario> buscarTodos() {
        Query consulta = manager.createNamedQuery("Usuario.FindAll");
        return consulta.getResultList();
    }

    public void excluir(Integer id){
        EntityTransaction tx = manager.getTransaction();
        Usuario usuario = manager.find(Usuario.class, id);
        try {
            tx.begin();
            manager.remove(usuario);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}

package br.com.doceria.as;

import br.com.doceria.dao.ClienteDAO;
import br.com.doceria.entity.Cliente;
import br.com.doceria.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteAS {

    public ClienteAS() {
    }

    EntityManager manager = new JPAUtil().getEntityManager();
    ClienteDAO clienteDAO = new ClienteDAO(manager);

    public void salvar(Cliente cliente) {
        try {
            clienteDAO.salvar(cliente);
        } catch (Exception e) {
            System.out.println("Erro ao Salvar Cliente");
        }
    }

    public Cliente editar(Cliente cliente) {
        Cliente clienteEditado = clienteDAO.buscarPorId(cliente.getId());

        clienteEditado.setNome(cliente.getNome());
        clienteEditado.setTelefone(cliente.getTelefone());
        clienteEditado.setEmail(cliente.getEmail());
        Cliente clienteAtualizado = clienteDAO.editar(clienteEditado);
        return clienteAtualizado;
    }

    public List<Cliente> listar() {
        return clienteDAO.buscarTodos();
    }

    public void excluir(Integer id) {
        try {
            clienteDAO.excluir(id);
        } catch (Exception e) {
            System.out.println("Erro ao tentar excluir usuario");
        }
        clienteDAO.excluir(id);
    }
}

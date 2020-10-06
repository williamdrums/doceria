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

    public void save(Cliente cliente) {
        try {
            clienteDAO.save(cliente);
        } catch (Exception e) {
            System.out.println("Erro ao Salvar Cliente");
        }
    }

    public Cliente update(Cliente cliente) {
        Cliente clienteEditado = clienteDAO.findById(cliente.getId());

        clienteEditado.setNome(cliente.getNome());
        clienteEditado.setTelefone(cliente.getTelefone());
        clienteEditado.setEmail(cliente.getEmail());
        Cliente clienteAtualizado = clienteDAO.update(clienteEditado);
        return clienteAtualizado;
    }

    public List<Cliente> findAll() {
        return clienteDAO.findAll();
    }

    public void delete(Integer id) {
        try {
            clienteDAO.delete(id);
        } catch (Exception e) {
            System.out.println("Erro ao tentar excluir usuario");
        }
        clienteDAO.delete(id);
    }
}

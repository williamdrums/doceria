package br.com.doceria.as;

import br.com.doceria.dao.ClienteDAO;
import br.com.doceria.entity.Cliente;
import br.com.doceria.util.JPAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteAS {

    private static final Logger logger = LoggerFactory.getLogger(ClienteAS.class);

    public ClienteAS() {
    }

    EntityManager manager = new JPAUtil().getEntityManager();
    ClienteDAO clienteDAO = new ClienteDAO(manager);

    public void save(Cliente cliente) {
        try {
            logger.info("Salvando Cliente: " + cliente.getNome());
            clienteDAO.save(cliente);
        } catch (Exception e) {
            logger.error(500 + "Erro ao Salvar Cliente:" + cliente.getNome());
        }
    }

    public Cliente update(Cliente cliente) {
        Cliente clienteUpdate = clienteDAO.findById(cliente.getId());
        Cliente clienteAtualizado = null;
        try {
            logger.info("Atualizando Clinete:" + cliente.getNome());
            clienteUpdate.setNome(cliente.getNome());
            clienteUpdate.setTelefone(cliente.getTelefone());
            clienteUpdate.setEmail(cliente.getEmail());
            clienteAtualizado = clienteDAO.update(clienteUpdate);
        } catch (Exception ex) {
            logger.error("Erro ao atualizar Cliente:" + cliente.getNome());
        }
        return clienteAtualizado;
    }

    public List<Cliente> findAll() {
        logger.info("Buscando todos os Clientes");
        return clienteDAO.findAll();
    }

    public void delete(Integer id) {
        try {
            logger.info("Deletando Cliente");
            clienteDAO.delete(id);
        } catch (Exception e) {
            logger.error("Erro ao tentar excluir usuario", 500);
        }
        clienteDAO.delete(id);
    }
}

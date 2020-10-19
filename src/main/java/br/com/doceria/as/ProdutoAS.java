package br.com.doceria.as;

import br.com.doceria.dao.ProdutoDAO;
import br.com.doceria.entity.Produto;
import br.com.doceria.util.JPAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoAS {
    private static final Logger logger = LoggerFactory.getLogger(ProdutoAS.class);


    EntityManager manager = new JPAUtil().getEntityManager();
    ProdutoDAO produtoDAO = new ProdutoDAO(manager);

    public ProdutoAS() {

    }

    public void save(Produto produto) {
        try {
            logger.info("Inserindo Dados do Produto");
            produtoDAO.save(produto);
        } catch (Exception exception) {
            logger.error(500 + "Erro ao salvar Produto:" + produto.getNome());
        }
    }

    public List<Produto> findAll() {
        logger.info("Buscando todos os produtos");
        return produtoDAO.findAll();
    }

    public Produto update(Produto produto) {
        Produto produtoNovo = null;
        try {
            logger.info("Atualizando Produto" + produto.getNome());
            Produto produtoUpdate = manager.find(Produto.class, produto.getId());
            produtoUpdate.setNome(produto.getNome());
            produtoUpdate.setValor(produto.getValor());
            produtoNovo = produtoDAO.update(produtoUpdate);

        } catch (Exception ex) {
            logger.error("Erro ao atualizar produto" + produto.getNome());
        }
        return produtoNovo;
    }

    public void delete(Integer id) {
        try {
            logger.info("Deletando Produto");
            produtoDAO.delete(id);
        } catch (Exception exception) {
            logger.error(500 + "Erro ao tentar excluir usuario");
        }
    }
}

package br.com.doceria.as;

import br.com.doceria.dao.ProdutoDAO;
import br.com.doceria.entity.Produto;
import br.com.doceria.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoAS {

    EntityManager manager = new JPAUtil().getEntityManager();
    ProdutoDAO produtoDAO = new ProdutoDAO(manager);

    public ProdutoAS() {

    }

    public void save(Produto produto) {
        try {
            produtoDAO.save(produto);
        } catch (Exception exception) {
            System.out.println(500 + "Erro ao salvar usuario");
        }
    }

    public List<Produto> findAll() {
        return produtoDAO.findAll();
    }

    public Produto update(Produto produto) {
        Produto produtoUpdate = manager.find(Produto.class, produto.getId());
        produtoUpdate.setNome(produto.getNome());
        produtoUpdate.setValor(produto.getValor());
        return produtoDAO.update(produtoUpdate);
    }

    public void delete(Integer id) {
        try {
            produtoDAO.delete(id);
        } catch (Exception exception) {
            System.out.println("Erro ao tentar excluir usuario");
        }
    }
}

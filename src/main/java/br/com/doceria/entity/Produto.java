package br.com.doceria.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@NamedQueries({
        @NamedQuery(name = "Produto.FindAll", query = "SELECT p FROM Produto p ORDER BY p.id"),
        @NamedQuery(name = "Produto.FindById", query = "SELECT p FROM Produto p WHERE p.id=:id"),
        @NamedQuery(name = "Produto.FindName", query = "SELECT p FROM Produto p WHERE p.nome = :nome"),
        @NamedQuery(name = "Produto.FindValue", query = "SELECT p FROM Produto p WHERE p.valor = :valor")
})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "valor")
    private BigDecimal valor;

    public Produto(){  }

    public Produto(Integer id, String nome, BigDecimal valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}

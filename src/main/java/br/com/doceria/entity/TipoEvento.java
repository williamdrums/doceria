package br.com.doceria.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tipoevento")
@NamedQueries({
        @NamedQuery(name= "TipoEvento.FindAll",query = "SELECT te FROM TipoEvento te ORDER BY te.id"),
        @NamedQuery(name="TipoEvento.FindById",query="SELECT te FROM TipoEvento te WHERE te.id = :id"),
        @NamedQuery(name = "TipoEvento.FindByEvent",query = "SELECT te FROM TipoEvento te WHERE te.descricao =: descricao")
})
public class TipoEvento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao", nullable = false)
    private String descricao;

    public TipoEvento() {

    }

    public TipoEvento(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

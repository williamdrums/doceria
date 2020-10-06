package br.com.doceria.entity;

import javax.persistence.*;

@Entity
@Table(name = "cerimonial")
@NamedQueries({
        @NamedQuery(name= "Cerimonial.FindAll",query = "SELECT c FROM Cerimonial c ORDER BY c.id"),
        @NamedQuery(name="Cerimonial.FindById",query="SELECT c FROM Cerimonial c WHERE c.id = :id"),
        @NamedQuery(name = "Cerimonial.FindByEvent",query = "SELECT c FROM Cerimonial c WHERE c.descricao =:descricao")
})
public class Cerimonial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;

    public Cerimonial(){

    }

    public Cerimonial(String descricao, Integer id){
        this.descricao = descricao;
        this.id = id;
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

    public void setDescricao(String decricao) {
        this.descricao = decricao;
    }
}

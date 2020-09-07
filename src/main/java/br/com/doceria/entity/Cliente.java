package br.com.doceria.entity;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@NamedQueries({
        @NamedQuery(name = "Cliente.FindAll", query = "SELECT c FROM Cliente c ORDER BY id"),
        @NamedQuery(name = "Cliente.FindByIdCliente", query = "SELECT c FROM Cliente c WHERE c.id = :id"),
        @NamedQuery(name = "Cliente.FindByName", query = "SELECT c FROM Cliente c WHERE c.nome = :nome"),
        @NamedQuery(name = "Cliente.FindByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email"),
        @NamedQuery(name = "Cliente.FindByTelefone", query = "SELECT c FROM Cliente c WHERE c.telefone = :telefone")
})
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "telefone")
    private String telefone;

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}

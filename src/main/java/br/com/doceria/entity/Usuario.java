package br.com.doceria.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@NamedQueries({
		@NamedQuery(name = "Usuario.FindAll", query = "SELECT u FROM Usuario u ORDER BY u.id"),
		@NamedQuery(name = "Usuario.FindByIdUser", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
		@NamedQuery(name = "Usuario.FindByName", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
		@NamedQuery(name = "Usuario.FindByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
		@NamedQuery(name = "Usuario.FindBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")
})
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "senha", nullable = false)
	private String senha;

	public Usuario() {

	}

	public Usuario(Integer id, String nome, String email, String senha) {
		
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}

package com.vemdaterra.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Campo Não pode ser Nulo")
	@Size(min = 2, max = 200)
	public String nome;

	@Email(message = "Campo precisa ser E-mail")
	@NotNull(message = "Campo Não pode ser Nulo")
	public String email;

	@NotNull(message = "Campo Não pode ser Nulo")
	@Size(min = 6)
	public String senha;

	public Integer cupom;

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoDeUsuario tipo;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({ "usuario", "produto", "categoria" })
	private List<Produto> produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Integer getCupom() {
		return cupom;
	}

	public void setCupom(Integer cupom) {
		this.cupom = cupom;
	}

	public TipoDeUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeUsuario tipo) {
		this.tipo = tipo;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

}

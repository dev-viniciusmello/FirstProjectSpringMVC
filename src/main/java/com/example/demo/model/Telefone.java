package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Telefone implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "varchar(20)")
	private String numero;
	
	@Column(columnDefinition = "varchar(20)")
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	@javax.persistence.Transient
	private boolean valido;
	
	@javax.persistence.Transient
	private List<String> errorMessageUser = new ArrayList<>();
	
	public Telefone() {

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public boolean isValido() {
		if (this.getNumero().isEmpty() || this.getNumero() == null) {
			errorMessageUser.add("Numero deve ser informado");
		}
		
		if (this.getTipo() == null || this.getTipo().isEmpty()) { 
			errorMessageUser.add("O tipo deve ser informado");
		}
		
		return (errorMessageUser.isEmpty()); 
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public List<String> getErrorMessageUser() {
		return errorMessageUser;
	}

	public void setErrorMessageUser(List<String> errorMessageUser) {
		this.errorMessageUser = errorMessageUser;
	}
}

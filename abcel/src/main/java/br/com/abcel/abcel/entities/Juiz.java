package br.com.abcel.abcel.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Juiz")
public class Juiz extends Pessoa implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	
	// Id está na classe Pessoa
	
	@Column(nullable = false, length = 256)
	private String senha;
	@OneToMany(mappedBy = "julgamento_id", cascade = CascadeType.ALL)
	private List<Julgamento> julgamentos;
	
	public Juiz() {}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<Julgamento> getJulgamentos() {
		return julgamentos;
	}
	
	public void setJulgamentos(List<Julgamento> julgamentos) {
		this.julgamentos = julgamentos;
	}
}

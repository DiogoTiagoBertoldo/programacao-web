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
@Table(name = "ProdutorRural")
public class ProdutorRural extends Pessoa implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	// id está na classe Pessoa

	@Column(nullable = false, length = 50)
	private String municipio;
	@Column(nullable = false, length = 50)
	private String bairro;
	@Column(nullable = false, length = 11)
	private int telefone;
	@OneToMany(mappedBy = "produtor_rural", cascade = CascadeType.ALL)
	private List<Produto> produtos;
	@OneToMany(mappedBy = "produtor_rural", cascade = CascadeType.ALL)
	private List<FichaInscricao> inscricoes;
	
	public ProdutorRural() {}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<FichaInscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(List<FichaInscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}
}

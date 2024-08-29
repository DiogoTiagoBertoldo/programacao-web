package com.entities;

import java.util.List;

public class ProdutorRural extends Pessoa {
	
	private String municipio;
	private String bairro;
	private int telefone;
	private List<Produto> produtos;
	private List<FichaInscricao> inscricoes;
	
	public ProdutorRural(String nome, String email, String municipio, String bairro, int telefone,
			List<Produto> produtos, List<FichaInscricao> inscricoes) {
		super(nome, email);
		this.municipio = municipio;
		this.bairro = bairro;
		this.telefone = telefone;
		this.produtos = produtos;
		this.inscricoes = inscricoes;
	}
	
	public String emitirRelatorio() {
		// TODO: criar o relatório a ser emitido
		return null;
	}
	
	public void addInscricao(FichaInscricao inscricao) {
		inscricoes.add(inscricao);
		produtos.add(inscricao.getProduto());
	}
	
	public void removeInscricao(FichaInscricao inscricao) {
		inscricoes.remove(inscricao);
		produtos.remove(inscricao.getProduto());
	}
	
	public void removeJulgamento(int index) throws IndexOutOfBoundsException {
		inscricoes.remove(index);
		produtos.remove(index);
	}
	
	public FichaInscricao getJulgamento(int index) throws IndexOutOfBoundsException {
		return inscricoes.get(index);
	}

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
}

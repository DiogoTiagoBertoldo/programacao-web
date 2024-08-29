package com.entities;

public class Produto {
	private String nome;
	private Variedade variedade;
	
	public Produto(String nome, Variedade variedade) {
		this.nome = nome;
		this.variedade = variedade;
	}
	
	public String emitirRelatorio() {
		// TODO: fazer relatorio
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Variedade getVariedade() {
		return variedade;
	}

	public void setVariedade(Variedade variedade) {
		this.variedade = variedade;
	}
}

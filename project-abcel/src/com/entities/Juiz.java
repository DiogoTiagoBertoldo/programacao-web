package com.entities;

import java.util.ArrayList;
import java.util.List;

public class Juiz extends Pessoa {
	
	private String senha;
	private List<Julgamento> julgamentos;
	
	public Juiz(String nome, String email, String senha) {
		super(nome, email);
		this.senha = senha;
		this.julgamentos = new ArrayList<>();
	}
	
	public String emitirRelatorio() {
		// TODO: criar o relatório a ser emitido
		return null;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void addJulgamento(Julgamento julgamento) {
		julgamentos.add(julgamento);
	}
	
	public void removeJulgamento(Julgamento julgamento) {
		julgamentos.remove(julgamento);
	}
	
	public void removeJulgamento(int index) throws IndexOutOfBoundsException {
		julgamentos.remove(index);
	}
	
	public Julgamento getJulgamento(int index) throws IndexOutOfBoundsException {
		return julgamentos.get(index);
	}
}

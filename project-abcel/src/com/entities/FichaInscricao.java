package com.entities;

import java.util.ArrayList;
import java.util.List;

public class FichaInscricao {
	private int numeroInscricao;
	private Produto produto;
	private ProdutorRural produtor;
	private TipoCultivo tipo;
	
	private List<Julgamento> julgamentos;
	private Double notaFinal;
	
	public FichaInscricao(int numeroInscricao, Produto produto, ProdutorRural produtor, TipoCultivo tipo) {
		this.numeroInscricao = numeroInscricao;
		this.produto = produto;
		this.produtor = produtor;
		this.tipo = tipo;
		this.julgamentos = new ArrayList<>();
	}
	
	public String emitirRelatorio() {
		// TODO: criar o relatório a ser emitido
		return null;
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

	public int getNumeroInscricao() {
		return numeroInscricao;
	}

	public void setNumeroInscricao(int numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutorRural getProdutor() {
		return produtor;
	}

	public void setProdutor(ProdutorRural produtor) {
		this.produtor = produtor;
	}

	public TipoCultivo getTipo() {
		return tipo;
	}

	public void setTipo(TipoCultivo tipo) {
		this.tipo = tipo;
	}

	public Double getNotaFinal() {
		if(julgamentos.isEmpty()) return null;
		
		var i = 0;
		var soma = 0.0;
		for(var each : julgamentos) {
			soma += each.gerarNotaFinal();
			i++;
		}
		notaFinal = soma/i;
		
		return notaFinal;
	}
}

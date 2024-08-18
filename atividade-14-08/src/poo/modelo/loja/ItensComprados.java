package poo.modelo.loja;

import java.util.Set;

public class ItensComprados {
	
	private int id;
	private int quantidade;
	private Set<Produto> produtos;
	private Compra compra;
	
	public ItensComprados(int id, int quantidade, Set<Produto> produtos, Compra compra) {
		this.id = id;
		this.quantidade = quantidade;
		this.produtos = produtos;
		this.compra = compra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}
}

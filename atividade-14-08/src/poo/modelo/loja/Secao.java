package poo.modelo.loja;

import java.util.Set;

public class Secao {
	
	private int id;
	private String nome;
	
	private Set<Produto> produtos;
	
	public Secao(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Set<Produto> getProdutos() {
		return produtos;
	}
	
	public void addProduto(Produto produto) {
		produtos.add(produto);
	}
	
	public void removeProduto(Produto produto) {
		produtos.remove(produto);
	}
}

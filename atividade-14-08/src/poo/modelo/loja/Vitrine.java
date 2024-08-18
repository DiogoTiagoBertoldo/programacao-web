package poo.modelo.loja;

import java.util.Set;

public class Vitrine {
	
	private Set<ItensVitrine> produtosVitrine;
	
	public Vitrine(Set<ItensVitrine> produtosVitrine) {
		this.produtosVitrine = produtosVitrine;
	}

	public Set<ItensVitrine> getProdutosVitrine() {
		return produtosVitrine;
	}

	public void setProdutosVitrine(Set<ItensVitrine> produtosVitrine) {
		this.produtosVitrine = produtosVitrine;
	}
	
	public void addProduto(ItensVitrine produto) {
		produtosVitrine.add(produto);
	}
	
	public void removeProduto(ItensVitrine produto) {
		produtosVitrine.remove(produto);
	}
}

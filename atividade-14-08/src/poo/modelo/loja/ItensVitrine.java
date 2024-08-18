package poo.modelo.loja;

public class ItensVitrine {
	
	private int qtdeDisponivel;
	private Produto produto;
	
	public ItensVitrine(int qtdeDisponivel, Produto produto) {
		this.qtdeDisponivel = qtdeDisponivel;
		this.produto = produto;
	}

	public int getQtdeDisponivel() {
		return qtdeDisponivel;
	}

	public void setQtdeDisponivel(int qtdeDisponivel) {
		this.qtdeDisponivel = qtdeDisponivel;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}

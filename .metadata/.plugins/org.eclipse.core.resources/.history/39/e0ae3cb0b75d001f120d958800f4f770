package poo.modelo.loja;

import java.util.Date;
import java.util.Set;

public class Compra {
	
	private int id;
	private boolean concluida;
	private Date dataCompra;
	private double valorFrete;
	
	private Cliente cliente;
	private Set<ItensComprados> produtosComprados;
	
	public Compra(int id, boolean concluida, Date dataCompra, double valorFrete, Cliente cliente,
			Set<ItensComprados> produtosComprados) {
		this.id = id;
		this.concluida = concluida;
		this.dataCompra = dataCompra;
		this.valorFrete = valorFrete;
		this.cliente = cliente;
		this.produtosComprados = produtosComprados;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isConcluida() {
		return concluida;
	}

	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public double getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<ItensComprados> getProdutosComprados() {
		return produtosComprados;
	}

	public void setProdutosComprados(Set<ItensComprados> produtosComprados) {
		this.produtosComprados = produtosComprados;
	}
}

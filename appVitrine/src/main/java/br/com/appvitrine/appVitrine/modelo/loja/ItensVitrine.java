package br.com.appvitrine.appVitrine.modelo.loja;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ItensVitrine")
public class ItensVitrine implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false, length = 5)
	private int qtdeDisponivel;
	@ManyToOne
	@JoinColumn(nullable = false, name = "id_produto")
	private Produto produto;
	@ManyToOne
	@JoinColumn(name = "id_vitrine")
	private Vitrine vitrine;

	public ItensVitrine() {}

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

	public Vitrine getVitrine() {
		return vitrine;
	}

	public void setVitrine(Vitrine vitrine) {
		this.vitrine = vitrine;
	}

	public UUID getId() {
		return id;
	}
}

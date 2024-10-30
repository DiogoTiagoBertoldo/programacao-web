package br.com.appvitrine.appVitrine.modelo.loja;

import static jakarta.persistence.GenerationType.AUTO;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Secao")
public class Secao implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = AUTO)
	private UUID id;
	@Column(nullable = false, length = 40)
	private String nome;
	//@OneToMany(mappedBy = "secao", cascade = CascadeType.ALL)
	@Transient
	private List<Produto> produtos;

	public Secao() {}

	public UUID getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}

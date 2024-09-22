package br.com.abcel.abcel.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Produto")
public class Produto implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(nullable = false, length = 40)
	private String nome;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false, name = "produto_id")
	private Variedade variedade;
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	private FichaInscricao inscricao;
	
	public Produto() {}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

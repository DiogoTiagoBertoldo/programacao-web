package br.com.abcel.abcel.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "FichaInscricao")
public class FichaInscricao implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id; // pode ser o número de inscricao

	@ManyToOne
	@JoinColumn(nullable = false, name = "inscricao_id")
	private Produto produto;
	@ManyToOne
	@JoinColumn(nullable = false, name = "inscricao_id")
	private ProdutorRural produtor;

	@Transient
	private TipoCultivo tipoCultivo;
	@Transient
	private List<Julgamento> julgamentos;
	@Transient
	private Double notaFinal;

	public FichaInscricao() {}

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

	public List<Julgamento> getJulgamentos() {
		return julgamentos;
	}

	public void setJulgamentos(List<Julgamento> julgamentos) {
		this.julgamentos = julgamentos;
	}

	public Double getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(Double notaFinal) {
		this.notaFinal = notaFinal;
	}

	public UUID getId() {
		return id;
	}

	public TipoCultivo getTipoCultivo() {
		return tipoCultivo;
	}

	public void setTipoCultivo(TipoCultivo tipoCultivo) {
		this.tipoCultivo = tipoCultivo;
	}
}

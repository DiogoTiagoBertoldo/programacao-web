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
@Table(name = "Julgamento")
public class Julgamento implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@ManyToOne
	@JoinColumn(nullable = false, name = "inscricao_id")
	private FichaInscricao inscricao;
	@ManyToOne
	@JoinColumn(nullable = false, name = "inscricao_id")
	private Juiz juiz;

	@Transient
	private List<Criterio> criterios;
	
	public Julgamento() {}

	public FichaInscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(FichaInscricao inscricao) {
		this.inscricao = inscricao;
	}

	public Juiz getJuiz() {
		return juiz;
	}

	public void setJuiz(Juiz juiz) {
		this.juiz = juiz;
	}

	public List<Criterio> getCriterios() {
		return criterios;
	}

	public void setCriterios(List<Criterio> criterios) {
		this.criterios = criterios;
	}

	public UUID getId() {
		return id;
	}
}

package br.com.project_abcel.abcel.entities.competition;

import static jakarta.persistence.GenerationType.AUTO;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import br.com.project_abcel.abcel.access.utils.SetGenericInheritance;
import br.com.project_abcel.abcel.entities.persons.Farmer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Registration")
public class Registration implements Serializable, SetGenericInheritance<Farmer> {
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = AUTO)
	private UUID id;
	@Column(nullable = false)
	private Registration product;
	@ManyToOne
	@JoinColumn(name = "farmer_id")
	private Farmer farmer;

	@Transient
	private List<Judgement> judgements;
	@Column(columnDefinition = "DECIMAL(2,1)", nullable = true)
	private Double finalScore;

	public Registration() {
	}

	@Override
	public void setInheritance(Farmer farmer) {
		this.farmer = farmer;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Registration getProduct() {
		return product;
	}

	public void setProduct(Registration product) {
		this.product = product;
	}

	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	public List<Judgement> getJudgements() {
		return judgements;
	}

	public void setJudgements(List<Judgement> judgements) {
		this.judgements = judgements;
	}

	public Double getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(Double finalScore) {
		this.finalScore = finalScore;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

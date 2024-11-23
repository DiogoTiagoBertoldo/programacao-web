package br.com.project_abcel.abcel.entities.competition;

import static jakarta.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.project_abcel.abcel.access.utils.SetGenericInheritance;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Score")
public class Score implements Serializable, SetGenericInheritance<Judgement> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = AUTO)
	private UUID id;

	@Column(columnDefinition = "decimal(2)", nullable = false)
	private int quality;
	@Column(columnDefinition = "decimal(2)", nullable = false)
	private int appearance;
	@Column(columnDefinition = "decimal(2)", nullable = false)
	private int size;

	@ManyToOne
	@JoinColumn(name = "judgement_id")
	@JsonBackReference
	private Judgement judgement;

	public Score() {
	}
	
	@Override
	public void setInheritance(Judgement t) {
		judgement = t;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Judgement getJudgement() {
		return judgement;
	}

	public void setJudgement(Judgement judgement) {
		this.judgement = judgement;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public int getAppearance() {
		return appearance;
	}

	public void setAppearance(int appearance) {
		this.appearance = appearance;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}

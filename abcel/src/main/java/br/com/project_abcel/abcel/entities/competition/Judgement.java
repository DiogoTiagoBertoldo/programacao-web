package br.com.project_abcel.abcel.entities.competition;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.AUTO;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.project_abcel.abcel.access.utils.GenericListMethods;
import br.com.project_abcel.abcel.access.utils.SetGenericInheritance;
import br.com.project_abcel.abcel.entities.persons.Judge;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Judgement")
public class Judgement implements Serializable, SetGenericInheritance<Judge>, GenericListMethods<Score> {
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = AUTO)
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "judge_id")
	@JsonBackReference
	private Judge judge;

	@OneToMany(fetch = LAZY, mappedBy = "judgement", cascade = ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Score> scores;

	public Judgement() {
	}

	@Override
	public void add(Score e) {
		scores.add(e);
	}

	@Override
	public List<Score> genericList() {
		return scores;
	}

	@Override
	public void setInheritance(Judge t) {
		judge = t;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Judge getJudge() {
		return judge;
	}

	public void setJudge(Judge judge) {
		this.judge = judge;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
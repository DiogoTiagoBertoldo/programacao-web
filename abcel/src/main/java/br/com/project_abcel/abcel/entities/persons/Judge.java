package br.com.project_abcel.abcel.entities.persons;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.project_abcel.abcel.access.utils.GenericListMethods;
import br.com.project_abcel.abcel.entities.competition.Judgement;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Judge")
public class Judge extends Person implements Serializable, GenericListMethods<Judgement> {
	@Serial
	private static final long serialVersionUID = 1L;

	@Column(length = 100, nullable = false)
	private String password;
	@OneToMany(fetch = LAZY, mappedBy = "judge", cascade = ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Judgement> judgements;

	public Judge() {
	}

	@Override
	public void add(Judgement e) {
		judgements.add(e);
	}

	@Override
	public List<Judgement> genericList() {
		return judgements;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Judgement> getJudgements() {
		return judgements;
	}

	public void setJudgements(List<Judgement> judgements) {
		this.judgements = judgements;
	}
}
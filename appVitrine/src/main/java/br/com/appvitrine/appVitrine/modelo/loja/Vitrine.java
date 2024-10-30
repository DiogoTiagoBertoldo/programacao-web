package br.com.appvitrine.appVitrine.modelo.loja;

import static jakarta.persistence.GenerationType.AUTO;
import static jakarta.persistence.TemporalType.DATE;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Vitrine")
public class Vitrine implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = AUTO)
	private UUID id;
	@Temporal(DATE)
	private Date dataInicio;
	@Temporal(DATE)
	private Date dataFim;
	//@OneToMany(mappedBy = "vitrine", cascade = CascadeType.ALL)
	@Transient
	private List<ItensVitrine> itensVitrine;

	public Vitrine() {}

	public UUID getId() {
		return id;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public List<ItensVitrine> getItensVitrine() {
		return itensVitrine;
	}

	public void setItensVitrine(List<ItensVitrine> itensVitrine) {
		this.itensVitrine = itensVitrine;
	}
}

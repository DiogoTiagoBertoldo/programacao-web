package br.com.appvitrine.appVitrine.modelo.loja;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.AUTO;
import static jakarta.persistence.TemporalType.TIMESTAMP;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;

@Entity
@Table(name = "compra")
public class Compra implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = AUTO)
	private UUID id;
	@Temporal(TIMESTAMP)
	private Date dataCompra;
	@Column(columnDefinition = "DECIMAL(5,2)")
	private BigDecimal valorFrete;
	@OneToMany(mappedBy = "compra", cascade = ALL)
	private List<ItensComprados> itensComprados;
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	@Column
	private boolean concluida;

	public double calcularValorFinal() {
		double total = 0.0;
		for (var each : itensComprados) {
			total += (each.getQuantidade() * each.getValor().floatValue());
		}
		total += valorFrete.floatValue();
		return total;
	}

	public Compra() {
	}

	public UUID getId() {
		return id;
	}

	public boolean isConcluida() {
		return concluida;
	}

	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public BigDecimal getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}

	public List<ItensComprados> getItensComprados() {
		return itensComprados;
	}

	public void setItensComprados(List<ItensComprados> itensComprados) {
		this.itensComprados = itensComprados;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}

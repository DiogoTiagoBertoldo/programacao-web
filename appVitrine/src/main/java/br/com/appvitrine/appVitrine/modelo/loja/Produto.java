package br.com.appvitrine.appVitrine.modelo.loja;

import static jakarta.persistence.GenerationType.AUTO;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Produto")
public class Produto implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = AUTO)
	private UUID id;
	@Column(nullable = false, length = 40)
	private String nome;
	@Column(nullable = false, length = 100)
	private String descricao;
	@Column(columnDefinition = "DECIMAL(7,2)")
	private BigDecimal valor;
	@Column(nullable = false, length = 5)
	private int qtdeEstoque;
	@Column(nullable = false, length = 1)
	private int estoqueMinimo;
	@Column(length = 50)
	private String imagem;
	@ManyToOne
	@JoinColumn(name = "id_secao")
	private Secao secao;
	//@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	@Transient
	private List<ItensVitrine> listaVitrines;
	//@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	@Transient
	private List<ItensComprados> listaCompras;

	public Produto() {}

	public UUID getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public int getQtdeEstoque() {
		return qtdeEstoque;
	}

	public void setQtdeEstoque(int qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}

	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

//	public String getImagem() {
//		return imagem;
//	}
//
//	public void setImagem(String imagem) {
//		this.imagem = imagem;
//	}

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

	public List<ItensVitrine> getListaVitrines() {
		return listaVitrines;
	}

	public void setListaVitrines(List<ItensVitrine> listaVitrines) {
		this.listaVitrines = listaVitrines;
	}

	public List<ItensComprados> getListaCompras() {
		return listaCompras;
	}

	public void setListaCompras(List<ItensComprados> listaCompras) {
		this.listaCompras = listaCompras;
	}
}

package poo.modelo.loja;

import java.util.Date;
import java.util.Set;

public class Cliente extends Usuario {

	private Date dataNascimento;
	private Set<Compra> compras;
	
	public Cliente(int id, String nome, String email, String senha, Date dataNascimento, Set<Compra> compras) {
		super(id, nome, email, senha);
		this.dataNascimento = dataNascimento;
		this.compras = compras;
	}

	public void CalcularIdade() {
		// TODO
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Set<Compra> getCompras() {
		return compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}
}

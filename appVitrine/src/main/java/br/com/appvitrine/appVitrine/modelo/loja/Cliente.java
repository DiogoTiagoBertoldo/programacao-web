package br.com.appvitrine.appVitrine.modelo.loja;

import java.io.Serial;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "UsuarioCliente")
public class Cliente extends Usuario implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	//@OneToMany(mappedBy = "CLIENTES", cascade = CascadeType.ALL)
	@Transient
	private List<Compra> historicoCompras;

	public int calcularIdade() {
		if (this.dataNascimento != null) {
			Calendar dtNasc = new GregorianCalendar();
			dtNasc.setTime(this.dataNascimento);
			Calendar hoje = Calendar.getInstance();
			int idade = hoje.get(Calendar.YEAR) - dtNasc.get(Calendar.YEAR);
			// trazer dtNasc para ano atual
			dtNasc.add(Calendar.YEAR, idade);
			if (hoje.before(dtNasc)) {
				idade--;
			}
			return idade;
		} else {
			return 0;
		}
	}

	public Cliente() {}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			sdf.setLenient(false);
			this.dataNascimento = sdf.parse(dataNascimento);
		} catch (ParseException ex) {
			System.out.println("Data em formato errado!");
		}
	}

	public List<Compra> getHistoricoCompras() {
		return historicoCompras;
	}

	public void setHistoricoCompras(List<Compra> historicoCompras) {
		this.historicoCompras = historicoCompras;
	}
}
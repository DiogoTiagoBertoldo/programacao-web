package br.com.appvitrine.appVitrine.modelo.acesso;

import java.io.Serial;
import java.io.Serializable;

import br.com.appvitrine.appVitrine.modelo.loja.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PERFIS.ADMS")
public class UsuarioADM extends Usuario implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "PERFIS")
	private Perfil perfil;

    public UsuarioADM() {}

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}

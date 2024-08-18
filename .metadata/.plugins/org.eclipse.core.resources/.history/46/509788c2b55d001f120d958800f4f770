package poo.modelo.acesso;

import java.util.Set;

import poo.modelo.loja.Usuario;

public class UsuarioADM extends Usuario {

	private Perfil perfil;
	private Set<Perfil> perfis;

	public UsuarioADM(int id, String nome, String email, String senha, Perfil perfil, Set<Perfil> perfis) {
		super(id, nome, email, senha);
		this.perfil = perfil;
		this.perfis = perfis;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}
}

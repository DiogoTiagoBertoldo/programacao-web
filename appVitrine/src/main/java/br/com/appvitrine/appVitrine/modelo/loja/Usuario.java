package br.com.appvitrine.appVitrine.modelo.loja;

import static jakarta.persistence.GenerationType.TABLE;
import static jakarta.persistence.InheritanceType.TABLE_PER_CLASS;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;

@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
public abstract class Usuario {
	@Id
	@GeneratedValue(strategy = TABLE)
	private UUID id;
	@Column(nullable = false, length = 100)
	private String nome;
	@Column(nullable = false, length = 100, unique = true)
	private String email;
	@Column(nullable = false, length = 100, unique = true)
	private String senha;

	public boolean logar() {
		return true;
	}

	public Usuario() {}

	public UUID getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public String getSenha() {
//		return senha;
//	}
//
//	public void setSenha(String senha) {
//		this.senha = senha;
//	}
}

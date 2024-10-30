package br.com.appvitrine.appVitrine.modelo.acesso;

import static jakarta.persistence.GenerationType.AUTO;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Perfil")
public class Perfil implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = AUTO)
	private UUID id;
	@Column(nullable = false, length = 100)
    private String descricao;
	//@OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL)
	@Transient
    private List<UsuarioADM> usuarios;

    public Perfil() {}

    public UUID getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void addUsuario(UsuarioADM usuario) {
    	if(usuarios == null) usuarios = new ArrayList<>();
    	usuarios.add(usuario);
    }
    
    public UsuarioADM getUsuario(int index) throws IndexOutOfBoundsException, NullPointerException {
    	return usuarios.get(index);
    }
}

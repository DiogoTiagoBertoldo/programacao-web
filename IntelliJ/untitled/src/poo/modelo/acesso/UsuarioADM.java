package poo.modelo.acesso;

import poo.modelo.loja.Usuario;

public class UsuarioADM extends Usuario {

    private Perfil perfil;

    public UsuarioADM() {
    }

    public UsuarioADM(Perfil perfil) {
        this.perfil = perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Perfil getPerfil() {
        return perfil;
    }
}

package poo.modelo.acesso;

import java.util.ArrayList;
import java.util.List;

public class Perfil {
    private int id;
    private String descricao;

    private List<UsuarioADM> usuarios;

    public Perfil(){
    }

    public Perfil(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        usuarios = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void addUsuario(UsuarioADM usuario) {
        usuarios.add(usuario);
    }

    public void removeUsuario(UsuarioADM usuario) {
        usuarios.remove(usuario);
    }

    public UsuarioADM getUsuario(int index) throws IndexOutOfBoundsException {
        return usuarios.get(index);
    }
}

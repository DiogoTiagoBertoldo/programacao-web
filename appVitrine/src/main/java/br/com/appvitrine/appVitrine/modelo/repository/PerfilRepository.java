package br.com.appvitrine.appVitrine.modelo.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.appvitrine.appVitrine.modelo.acesso.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, UUID> {
}

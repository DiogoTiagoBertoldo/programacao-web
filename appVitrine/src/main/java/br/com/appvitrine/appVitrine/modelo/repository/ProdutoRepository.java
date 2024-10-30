package br.com.appvitrine.appVitrine.modelo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.appvitrine.appVitrine.modelo.loja.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}

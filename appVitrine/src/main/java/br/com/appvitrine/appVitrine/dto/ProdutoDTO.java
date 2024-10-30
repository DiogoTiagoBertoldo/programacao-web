package br.com.appvitrine.appVitrine.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDTO(
		@NotBlank String nome, String descricao,
		@NotNull BigDecimal valor, 
		String imagem, int qtdeEstoque, int estoqueMinimo
		) {
}

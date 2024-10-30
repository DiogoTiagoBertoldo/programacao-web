package br.com.appvitrine.appVitrine.dto;

import jakarta.validation.constraints.NotBlank;

public record PerfilDTO(@NotBlank String descricao) {
}

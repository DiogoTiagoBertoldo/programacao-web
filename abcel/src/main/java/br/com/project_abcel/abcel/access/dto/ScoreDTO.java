package br.com.project_abcel.abcel.access.dto;

import jakarta.validation.constraints.NotBlank;

public record ScoreDTO(@NotBlank int quality, int appearance, int size) {
}

package br.com.project_abcel.abcel.access.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDTO(@NotNull String name, String variety,
						 @NotBlank int type) {

}

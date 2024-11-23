package br.com.project_abcel.abcel.access.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FarmerDTO(@NotNull String name, String email, @NotNull String city, String neighborhood,
		@NotBlank int phone) {

}

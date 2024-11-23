package br.com.project_abcel.abcel.access.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record RegistrationDTO(@NotNull UUID product, UUID Farmer) {

}

package br.com.project_abcel.abcel.access.dto;

import jakarta.validation.constraints.NotNull;

public record JudgeDTO(@NotNull String name, String email, String password) {

}

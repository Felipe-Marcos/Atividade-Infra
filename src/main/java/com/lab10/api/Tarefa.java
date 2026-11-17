package com.lab10.api;

import jakarta.validation.constraints.NotBlank;

public record Tarefa(Long id, @NotBlank String titulo, boolean concluida) {
}

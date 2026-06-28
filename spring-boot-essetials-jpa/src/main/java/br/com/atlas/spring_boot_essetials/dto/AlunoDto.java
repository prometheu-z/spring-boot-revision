package br.com.atlas.spring_boot_essetials.dto;

import jakarta.validation.constraints.NotBlank;

public record AlunoDto(@NotBlank(message = "Nome não deve ser vazio") String nome,
                       @NotBlank(message = "Email não deve ser vazio") String email) {
}

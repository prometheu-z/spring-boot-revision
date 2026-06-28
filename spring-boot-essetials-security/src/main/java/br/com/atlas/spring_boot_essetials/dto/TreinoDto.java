package br.com.atlas.spring_boot_essetials.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record TreinoDto(@NotNull(message = "O aluno é obrigatorio") UUID alunoId,
                        @NotBlank(message = "O nome do treino é obrigatorio") String nome,
                        @NotEmpty(message = "É necessário ao menos um exercicio") List<UUID> exercicios) {
}

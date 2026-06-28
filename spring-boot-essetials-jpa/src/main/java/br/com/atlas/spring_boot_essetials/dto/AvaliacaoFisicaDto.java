package br.com.atlas.spring_boot_essetials.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.rmi.server.UID;
import java.util.UUID;

public record AvaliacaoFisicaDto(@NotNull(message = "O id do aluno é necessário") UUID alunoId,
                                 @NotNull(message = "A altura é necessária") BigDecimal altura,
                                 @NotNull(message = "O peso é necessário") BigDecimal peso,
                                 @NotNull(message = "O percentual de gordura é necessário") BigDecimal gorduraCorporal) {
}

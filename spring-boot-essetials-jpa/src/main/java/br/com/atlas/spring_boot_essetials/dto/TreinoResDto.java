package br.com.atlas.spring_boot_essetials.dto;

import br.com.atlas.spring_boot_essetials.database.model.Exercicios;
import br.com.atlas.spring_boot_essetials.database.model.Treinos;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public record TreinoResDto(UUID id, String nome, UUID alunoId, String  AlunoNome, Set<Exercicios> exercicios) {


    public static TreinoResDto from(Treinos treino) {
        return new TreinoResDto(
                treino.getId(),
                treino.getNome(),
                treino.getAluno().getId(),
                treino.getAluno().getNome(),
                new HashSet<>(treino.getExercicios())
        );
    }
}

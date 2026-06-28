package br.com.atlas.spring_boot_essetials.service;

import br.com.atlas.spring_boot_essetials.database.model.Alunos;
import br.com.atlas.spring_boot_essetials.database.model.Exercicios;
import br.com.atlas.spring_boot_essetials.database.model.Treinos;
import br.com.atlas.spring_boot_essetials.database.repository.AlunoRepository;
import br.com.atlas.spring_boot_essetials.database.repository.ExerciciosRepository;
import br.com.atlas.spring_boot_essetials.database.repository.TreinoRepository;
import br.com.atlas.spring_boot_essetials.dto.TreinoDto;
import br.com.atlas.spring_boot_essetials.dto.TreinoResDto;
import br.com.atlas.spring_boot_essetials.exception.BadRequestExcepion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TreinoService {

    private final TreinoRepository treinoRepository;
    private final ExerciciosRepository exerciciosRepository;
    private final AlunoRepository alunoRepository;


    public TreinoResDto crateTreino(TreinoDto treinoDto){
        Alunos alunos = alunoRepository.findById(treinoDto.alunoId()).orElseThrow(() -> new BadRequestExcepion("O Aluno não existe"));

        Treinos treinos = treinoRepository.findByNomeAndAlunoId(treinoDto.nome(), treinoDto.alunoId()).orElse(null);

        if(treinos != null){
            throw new BadRequestExcepion("O treino com esse nome já existe para o aluno "+alunos.getNome());
        }
        Set<Exercicios> exercicios = new HashSet<>();


        for (UUID exercicioId : treinoDto.exercicios()){
            Exercicios exercicio = exerciciosRepository.findById(exercicioId).orElseThrow(() -> new BadRequestExcepion("O exercicio de id: "+ exercicioId + " não existe"));

            exercicios.add(exercicio);
        }

        Treinos treino = Treinos.builder()
                .nome(treinoDto.nome())
                .aluno(alunos)
                .exercicios(exercicios)
                .build();

        treinoRepository.save(treino);


        return TreinoResDto.from(treino);


    }

    public void removerTreino(UUID treinoId){

        Treinos treinos = treinoRepository.findById(treinoId).orElse(null);
        if(treinos == null){
            return;
        }
        treinoRepository.delete(treinos);
    }


}

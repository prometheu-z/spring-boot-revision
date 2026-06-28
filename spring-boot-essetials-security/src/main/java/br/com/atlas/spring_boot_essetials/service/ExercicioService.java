package br.com.atlas.spring_boot_essetials.service;

import br.com.atlas.spring_boot_essetials.database.model.Exercicios;
import br.com.atlas.spring_boot_essetials.database.repository.ExerciciosRepository;
import br.com.atlas.spring_boot_essetials.dto.ExercicioDto;
import ch.qos.logback.core.encoder.EchoEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExercicioService {

    private final ExerciciosRepository exerciciosRepository;

    public List<Exercicios> findAll(){


        return exerciciosRepository.findAll();
    }

    public Exercicios save(ExercicioDto exercicioDto){
        Exercicios exercicio = Exercicios.builder().nome(exercicioDto.nome())
                .grupoMuscular(exercicioDto.grupoMuscular()).build();

        return exerciciosRepository.save(exercicio);

    }

    public List<Exercicios > getExercicioByGrupoMuscular(String grupoMuscular){


        return exerciciosRepository.findAllByGrupoMuscular(grupoMuscular);
    }


}

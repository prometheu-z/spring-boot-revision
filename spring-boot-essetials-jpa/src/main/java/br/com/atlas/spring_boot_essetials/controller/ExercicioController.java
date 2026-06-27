package br.com.atlas.spring_boot_essetials.controller;

import br.com.atlas.spring_boot_essetials.database.model.Exercicios;
import br.com.atlas.spring_boot_essetials.dto.ExercicioDto;
import br.com.atlas.spring_boot_essetials.service.ExercicioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/exercicios")
@RequiredArgsConstructor
@Validated
public class ExercicioController {

    private final ExercicioService exercicioService;

    @GetMapping
    public ResponseEntity<List<ExercicioDto>> findAll(){
        List<ExercicioDto> exerciciosdtos = new ArrayList<>();

        exercicioService.findAll().forEach(e -> {
            ExercicioDto ex = new ExercicioDto(e.getNome(), e.getGrupoMuscular());
            exerciciosdtos.add(ex);
        });
        return ResponseEntity.status(HttpStatus.OK).body(exerciciosdtos);

    }
    @GetMapping
    @RequestMapping("/grupos/{grupoMuscular}")
    public ResponseEntity<List<ExercicioDto>> getByGrupoMuscular(@PathVariable String grupoMuscular){
        List<ExercicioDto> exercicioDtos = new ArrayList<>();

        exercicioService.getExercicioByGrupoMuscular(grupoMuscular).forEach(e -> {
            ExercicioDto dto = new ExercicioDto(e.getNome(), e.getGrupoMuscular());
            exercicioDtos.add(dto);
        });

        return ResponseEntity.status(HttpStatus.OK).body(exercicioDtos);

    }

    @PostMapping
    public ResponseEntity<Exercicios> createExercicio(@Valid @RequestBody ExercicioDto exercicioDto){

        return ResponseEntity.status(HttpStatus.CREATED).body(exercicioService.save(exercicioDto));
    }
}

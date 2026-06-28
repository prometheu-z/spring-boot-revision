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
    public ResponseEntity<List<Exercicios>> findAll(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(exercicioService.findAll());

    }
    @GetMapping
    @RequestMapping("/grupos/{grupoMuscular}")
    public ResponseEntity<List<Exercicios>> getByGrupoMuscular(@PathVariable String grupoMuscular){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(exercicioService.getExercicioByGrupoMuscular(grupoMuscular));

    }

    @PostMapping
    public ResponseEntity<Exercicios> createExercicio(@Valid @RequestBody ExercicioDto exercicioDto){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(exercicioService.save(exercicioDto));
    }
}

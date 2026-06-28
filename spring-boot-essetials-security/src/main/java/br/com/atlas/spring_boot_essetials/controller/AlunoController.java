package br.com.atlas.spring_boot_essetials.controller;

import br.com.atlas.spring_boot_essetials.database.model.Alunos;
import br.com.atlas.spring_boot_essetials.database.repository.AlunoRepository;
import br.com.atlas.spring_boot_essetials.dto.AlunoDto;
import br.com.atlas.spring_boot_essetials.dto.AvaliacaoFisicaDto;
import br.com.atlas.spring_boot_essetials.service.AlunoService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/aluno")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoDto>> findAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(alunoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Alunos> createAluno(@Valid @RequestBody AlunoDto alunoDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(alunoService.createAluno(alunoDto));
    }

    @GetMapping("/{aluno}/avaliacao")
    public ResponseEntity<AvaliacaoFisicaDto> getAvaliacao(@PathVariable(name = "aluno") UUID alunoid){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(alunoService.getAvaliacaoAluno(alunoid));
    }
}

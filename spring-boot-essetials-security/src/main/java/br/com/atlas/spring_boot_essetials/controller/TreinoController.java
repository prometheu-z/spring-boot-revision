package br.com.atlas.spring_boot_essetials.controller;


import br.com.atlas.spring_boot_essetials.database.model.Treinos;
import br.com.atlas.spring_boot_essetials.dto.TreinoDto;
import br.com.atlas.spring_boot_essetials.dto.TreinoResDto;
import br.com.atlas.spring_boot_essetials.service.TreinoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/treinos")
public class TreinoController {

    private final TreinoService treinoService;


    @PostMapping
    public ResponseEntity<TreinoResDto> criarTreino(@Valid @RequestBody TreinoDto treinoDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(treinoService.crateTreino(treinoDto));
    }

    @DeleteMapping("/{treinoId}")
    @ResponseStatus(HttpStatus.OK)
    public void removerTreino(@PathVariable UUID treinoId){
        treinoService.removerTreino(treinoId);
    }
}

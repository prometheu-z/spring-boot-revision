package br.com.atlas.spring_boot_essetials.controller;

import br.com.atlas.spring_boot_essetials.database.model.AvaliacaoFisicas;
import br.com.atlas.spring_boot_essetials.dto.AvaliacaoFisicaDto;
import br.com.atlas.spring_boot_essetials.dto.AvaliacaoFisicaProjection;
import br.com.atlas.spring_boot_essetials.service.AvaliacaoFisicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/avaliacoes")
@RequiredArgsConstructor
public class AvaliacaoFisicaController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping
    public ResponseEntity<AvaliacaoFisicas> criarAvaliacao(@RequestBody AvaliacaoFisicaDto avaliacaoFisicaDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoFisicaService.criarAvaliacao(avaliacaoFisicaDto));
    }


    @GetMapping
    public ResponseEntity<List<AvaliacaoFisicaProjection>> getAllAvaliacao(){
        return ResponseEntity.status(HttpStatus.OK).body(avaliacaoFisicaService.getAllAvaliacao());
    }

    @GetMapping("/page")
    public Page<AvaliacaoFisicaProjection> getPageAllAvaliacao(@RequestParam(name = "size") Integer size,
                                                               @RequestParam(name = "page") Integer page){
        return avaliacaoFisicaService.getPageAllAvaliacao(page, size);
    }


}

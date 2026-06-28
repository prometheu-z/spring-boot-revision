package br.com.atlas.spring_boot_essetials.service;

import br.com.atlas.spring_boot_essetials.database.model.Alunos;
import br.com.atlas.spring_boot_essetials.database.model.AvaliacaoFisicas;
import br.com.atlas.spring_boot_essetials.database.repository.AlunoRepository;
import br.com.atlas.spring_boot_essetials.database.repository.AvaliacaoFisicaRepository;
import br.com.atlas.spring_boot_essetials.dto.AvaliacaoFisicaDto;
import br.com.atlas.spring_boot_essetials.dto.AvaliacaoFisicaProjection;
import br.com.atlas.spring_boot_essetials.exception.BadRequestExcepion;
import br.com.atlas.spring_boot_essetials.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.rmi.server.UID;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoFisicaService {

    private final AlunoRepository alunoRepository;
    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    public AvaliacaoFisicas criarAvaliacao(AvaliacaoFisicaDto avaliacaoFisicaDto){

        Alunos aluno = alunoRepository.findById(avaliacaoFisicaDto.alunoId()).orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        AvaliacaoFisicas avaliacaoFisicas =aluno.getAvaliacaoFisicas();

        if(avaliacaoFisicas != null){
            throw new BadRequestExcepion("Avalição fisica já cadastrada para o aluno "+aluno.getNome());
        }

        avaliacaoFisicas = AvaliacaoFisicas.builder()
                .peso(avaliacaoFisicaDto.peso())
                .altura(avaliacaoFisicaDto.altura())
                .gorduraCorporal(avaliacaoFisicaDto.gorduraCorporal())
                .build();


        // tá com CascadeType.All (salva/altera/remove em cascata)
        aluno.setAvaliacaoFisicas(avaliacaoFisicas);
        alunoRepository.save(aluno);

        return aluno.getAvaliacaoFisicas();


    }

    public List<AvaliacaoFisicaProjection> getAllAvaliacao(){

        return avaliacaoFisicaRepository.getAllAvaliacaoFisica();
    }

    public Page<AvaliacaoFisicaProjection> getPageAllAvaliacao(Integer page, Integer size){

        return avaliacaoFisicaRepository.getPageAllAvaliacaoFisica(PageRequest.of(page, size));
    }
}

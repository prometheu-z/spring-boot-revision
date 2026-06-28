package br.com.atlas.spring_boot_essetials.service;

import br.com.atlas.spring_boot_essetials.database.model.Alunos;
import br.com.atlas.spring_boot_essetials.database.model.AvaliacaoFisicas;
import br.com.atlas.spring_boot_essetials.database.repository.AlunoRepository;
import br.com.atlas.spring_boot_essetials.dto.AlunoDto;
import br.com.atlas.spring_boot_essetials.dto.AvaliacaoFisicaDto;
import br.com.atlas.spring_boot_essetials.exception.BadRequestExcepion;
import br.com.atlas.spring_boot_essetials.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public Alunos createAluno(AlunoDto alunoDto){

        Alunos alunos = alunoRepository.findByEmail(alunoDto.email()).orElse(null);

        if(alunos != null){
            throw new BadRequestExcepion("Email já cadastrado para esse aluno");
        }

        alunos = Alunos.builder()
                .nome(alunoDto.nome())
                .email(alunoDto.email())
                .build();

        return alunoRepository.save(alunos);
    }

    public List<AlunoDto> findAll(){
        List<AlunoDto> alunoDtos = new ArrayList<>();

        alunoRepository.findAll().forEach(a -> {
            AlunoDto dto = new AlunoDto(a.getNome(), a.getEmail());

            alunoDtos.add(dto);
        });

        return alunoDtos;
    }

    public AvaliacaoFisicaDto getAvaliacaoAluno(UUID alunoId){
        Alunos aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        AvaliacaoFisicas avaliacaoFisicas = aluno.getAvaliacaoFisicas();

        if(avaliacaoFisicas == null){
            throw new NotFoundException("Avaliação fisica não encontrada para o aluno "+ aluno.getNome());
        }

        AvaliacaoFisicaDto dto = new AvaliacaoFisicaDto(alunoId, avaliacaoFisicas.getAltura(),
                avaliacaoFisicas.getPeso(), avaliacaoFisicas.getGorduraCorporal());
        return dto;

    }
}

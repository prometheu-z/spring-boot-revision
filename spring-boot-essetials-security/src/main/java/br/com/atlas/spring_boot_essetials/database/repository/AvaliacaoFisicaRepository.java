package br.com.atlas.spring_boot_essetials.database.repository;

import br.com.atlas.spring_boot_essetials.database.model.AvaliacaoFisicas;
import br.com.atlas.spring_boot_essetials.dto.AvaliacaoFisicaProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisicas, UUID> {

    @NativeQuery(value = """
        SELECT BIN_TO_UUID(a.id) idAluno,
               a.nome nomeAluno,
               BIN_TO_UUID(af.id) idAvaliacao,
               af.peso peso,
               af.altura altura,
               af.gordura_corporal gorduraCorporal
        FROM avaliacoes_fisicas af 
        INNER JOIN alunos a 
        ON a.avaliacao_fisica_id = af.id

""")
    List<AvaliacaoFisicaProjection> getAllAvaliacaoFisica();

    @NativeQuery(value = """
        SELECT BIN_TO_UUID(a.id) idAluno,
               a.nome nomeAluno,
               BIN_TO_UUID(af.id) idAvaliacao,
               af.peso peso,
               af.altura altura,
               af.gordura_corporal gorduraCorporal
        FROM avaliacoes_fisicas af 
        INNER JOIN alunos a 
        ON a.avaliacao_fisica_id = af.id

""", countQuery = """
        SELECT count(af.id)
        FROM avaliacoes_fisicas af 
        INNER JOIN alunos a 
        ON a.avaliacao_fisica_id = af.id

""")
    Page<AvaliacaoFisicaProjection> getPageAllAvaliacaoFisica(Pageable pageable);
}

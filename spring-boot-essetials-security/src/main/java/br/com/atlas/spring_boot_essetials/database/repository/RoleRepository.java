package br.com.atlas.spring_boot_essetials.database.repository;

import br.com.atlas.spring_boot_essetials.database.model.Alunos;
import br.com.atlas.spring_boot_essetials.database.model.AvaliacaoFisicas;
import br.com.atlas.spring_boot_essetials.dto.AvaliacaoFisicaDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;
import java.util.Optional;
import java.util.UUID;

public interface AlunoRepository extends JpaRepository<Alunos, UUID> {

    Optional<Alunos> findByEmail(String email);
}

package br.com.atlas.spring_boot_essetials.database.repository;

import br.com.atlas.spring_boot_essetials.database.model.Treinos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;
import java.util.Optional;
import java.util.UUID;

public interface TreinoRepository extends JpaRepository<Treinos, UUID> {

    Optional<Treinos> findByNomeAndAlunoId(String nome, UUID alunoId);
}

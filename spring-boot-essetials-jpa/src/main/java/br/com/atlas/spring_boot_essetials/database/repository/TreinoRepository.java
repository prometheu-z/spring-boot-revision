package br.com.atlas.spring_boot_essetials.database.repository;

import br.com.atlas.spring_boot_essetials.database.model.Treinos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;

public interface TreinoRepository extends JpaRepository<Treinos, UID> {
}

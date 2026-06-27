package br.com.atlas.spring_boot_essetials.database.repository;

import br.com.atlas.spring_boot_essetials.database.model.AvaliacaoFisicas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;

public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisicas, UID> {
}

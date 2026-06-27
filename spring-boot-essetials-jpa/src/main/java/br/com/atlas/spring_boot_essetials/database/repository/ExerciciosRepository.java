package br.com.atlas.spring_boot_essetials.database.repository;

import br.com.atlas.spring_boot_essetials.database.model.Exercicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.rmi.server.UID;
import java.util.List;

@Repository
//n precisa
public interface ExerciciosRepository extends JpaRepository<Exercicios, UID> {

    List<Exercicios> findAllByGrupoMuscular(String grupoMuscular);

    @NativeQuery(value = "select e from exercicios e where upper(e.grupo_muscular) = upper(:grupoMuscular)")
    List<Exercicios> geinfbyGrupo(@Param("grupoMuscular") String grupoMuscular);

}

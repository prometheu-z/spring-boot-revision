package br.com.atlas.spring_boot_essetials.database.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "treinos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Treinos {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 40)
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id")
    private Alunos aluno;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "treinos_exercicios",
            joinColumns = @JoinColumn(name = "treino_id"),
            inverseJoinColumns = @JoinColumn(name = "exercicio_id")
    )
    private Set<Exercicios> exercicios = new HashSet<>();
}


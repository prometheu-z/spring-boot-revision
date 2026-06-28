package br.com.atlas.spring_boot_essetials.database.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "alunos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Alunos {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name =  "avaliacao_fisica_id")
    private AvaliacaoFisicas avaliacaoFisicas;


    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
    private Set<Treinos> treinos = new HashSet<>();

}

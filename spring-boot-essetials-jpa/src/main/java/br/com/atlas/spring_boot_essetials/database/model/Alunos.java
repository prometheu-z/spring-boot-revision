package br.com.atlas.spring_boot_essetials.database.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "avaliacoes_fisicas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class avaliacaoFisicas {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private BigDecimal peso;
    @Column(nullable = false)
    private BigDecimal altura;

    @Column(name = "gordura_corporal", nullable = false)
    private BigDecimal gorduraCorporal;

}

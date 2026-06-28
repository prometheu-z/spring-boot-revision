package br.com.atlas.spring_boot_essetials.dto;

import java.math.BigDecimal;
import java.util.UUID;

public interface AvaliacaoFisicaProjection {
    String getIdAluno();
    String getNomeAluno();
    String getIdAvaliacao();
    BigDecimal getPeso();
    BigDecimal getAltura();
    BigDecimal getPercentualGordura();
}

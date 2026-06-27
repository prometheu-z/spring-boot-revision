package br.com.atlas.spring_boot_essetials.exception;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotBlankResponse {
    private String mensagem;
    private Integer codigo;
}


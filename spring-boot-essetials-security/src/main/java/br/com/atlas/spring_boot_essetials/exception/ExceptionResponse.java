package br.com.atlas.spring_boot_essetials.exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionResponse {
    private String mensagem;
    private Integer codigo;
}


package br.com.atlas.spring_boot_essetials.handler;

import br.com.atlas.spring_boot_essetials.exception.BadRequestExcepion;
import br.com.atlas.spring_boot_essetials.exception.ExceptionResponse;
import br.com.atlas.spring_boot_essetials.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {




    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> notBlank(MethodArgumentNotValidException e){
        ExceptionResponse ex = ExceptionResponse.builder()
                .mensagem(e.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
                        .collect(Collectors.joining(", ")))
                .codigo(HttpStatus.BAD_REQUEST.value())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> notFound(NotFoundException ex){
        ExceptionResponse res = ExceptionResponse.builder().mensagem(ex.getMessage()).codigo(HttpStatus.NOT_FOUND.value())
                .build();

        return ResponseEntity.status(res.getCodigo()).body(res);
    }

    @ExceptionHandler(BadRequestExcepion.class)
    public ResponseEntity<ExceptionResponse> badRequest(BadRequestExcepion ex){
        ExceptionResponse res = ExceptionResponse.builder().mensagem(ex.getMessage()).codigo(HttpStatus.BAD_REQUEST.value())
                .build();

        return ResponseEntity.status(res.getCodigo()).body(res);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handlerException(Exception ex){

        ExceptionResponse res = ExceptionResponse.builder().mensagem(ex.getMessage()).codigo(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();

        return ResponseEntity.status(res.getCodigo()).body(res);
    }

}

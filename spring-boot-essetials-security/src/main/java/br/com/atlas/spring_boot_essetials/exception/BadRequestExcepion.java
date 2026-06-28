package br.com.atlas.spring_boot_essetials.exception;

public class BadRequestExcepion extends RuntimeException {
    public BadRequestExcepion(String message) {
        super(message);
    }
}

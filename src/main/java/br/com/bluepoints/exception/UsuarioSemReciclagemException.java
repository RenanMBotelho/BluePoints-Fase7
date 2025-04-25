package br.com.bluepoints.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioSemReciclagemException extends RuntimeException {

    public UsuarioSemReciclagemException (String mensagem){
        super(mensagem);
    }

}

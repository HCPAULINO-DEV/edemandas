package com.projects.my.eDemandas_api.excpetion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(DemandaNaoEncontradaExcpetion.class)
    public ResponseEntity<RetornarErroDto> handlerDemandaNaoEncontrada(DemandaNaoEncontradaExcpetion ex){
        var status = HttpStatus.NOT_FOUND;
        var mensagem = new RetornarErroDto(status.toString(), ex.getMessage());
        return ResponseEntity.status(status).body(mensagem);
    }

    private record RetornarErroDto(
            String status,
            String mensagem
    ){}
}

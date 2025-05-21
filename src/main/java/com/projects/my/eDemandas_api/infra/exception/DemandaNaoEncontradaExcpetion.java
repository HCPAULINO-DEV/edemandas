package com.projects.my.eDemandas_api.infra.exception;

public class DemandaNaoEncontradaExcpetion extends RuntimeException{
    public DemandaNaoEncontradaExcpetion(String mensagem){
        super(mensagem);
    }
}

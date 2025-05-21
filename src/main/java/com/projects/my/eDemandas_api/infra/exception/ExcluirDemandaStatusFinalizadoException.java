package com.projects.my.eDemandas_api.infra.exception;

public class ExcluirDemandaStatusFinalizadoException extends RuntimeException{
    public ExcluirDemandaStatusFinalizadoException(String mensagem){
        super(mensagem);
    }
}

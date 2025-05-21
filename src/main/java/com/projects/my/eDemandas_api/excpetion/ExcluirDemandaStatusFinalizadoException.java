package com.projects.my.eDemandas_api.excpetion;

public class ExcluirDemandaStatusFinalizadoException extends RuntimeException{
    public ExcluirDemandaStatusFinalizadoException(String mensagem){
        super(mensagem);
    }
}

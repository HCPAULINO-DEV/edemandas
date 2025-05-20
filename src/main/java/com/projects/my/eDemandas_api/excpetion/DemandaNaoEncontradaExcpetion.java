package com.projects.my.eDemandas_api.excpetion;

public class DemandaNaoEncontradaExcpetion extends RuntimeException{
    public DemandaNaoEncontradaExcpetion(String mensagem){
        super(mensagem);
    }
}

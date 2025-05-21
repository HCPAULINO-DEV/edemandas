package com.projects.my.eDemandas_api.infra.validation;

import com.projects.my.eDemandas_api.entity.Demanda;
import com.projects.my.eDemandas_api.entity.Status;
import com.projects.my.eDemandas_api.infra.exception.ExcluirDemandaStatusFinalizadoException;
import com.projects.my.eDemandas_api.repository.DemandaRepository;
import org.springframework.stereotype.Component;

@Component
public class DemandaValidations {

    private final DemandaRepository demandaRepository;

    public DemandaValidations(DemandaRepository demandaRepository) {
        this.demandaRepository = demandaRepository;
    }

    public void validarExcluirDemandaStatusFinalizado(Demanda demanda){
        if (demanda.getStatus() != Status.FINALIZADO){
            throw new ExcluirDemandaStatusFinalizadoException("A demanda deve ter o status FINALIZADO para poder ser excluida!");
        }

    }
}

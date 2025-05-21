package com.projects.my.eDemandas_api.dto;

import com.projects.my.eDemandas_api.entity.Demanda;
import com.projects.my.eDemandas_api.entity.Status;

public record InformarDemandaDto(
        String id,
        String nome,
        String documento,
        Status status
) {
    public InformarDemandaDto(Demanda demanda) {
        this(
                demanda.getId().toString(),
                demanda.getNome(),
                demanda.getDocumento(),
                demanda.getStatus()
        );
    }
}

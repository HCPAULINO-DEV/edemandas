package com.projects.my.eDemandas_api.dto;

import com.projects.my.eDemandas_api.entity.Status;

import java.util.UUID;

public record InformarDemandaDto(
        String id,
        String nome,
        String documento,
        Status status
) {
}

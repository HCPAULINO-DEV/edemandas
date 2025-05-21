package com.projects.my.eDemandas_api.dto;

import com.projects.my.eDemandas_api.entity.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizarDemandaDto(

        @NotBlank
        String nome,

        @NotBlank
        String documento,

        @NotNull
        Status status
) {
}

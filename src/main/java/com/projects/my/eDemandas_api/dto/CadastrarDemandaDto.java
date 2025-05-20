package com.projects.my.eDemandas_api.dto;

import jakarta.validation.constraints.NotBlank;

public record CadastrarDemandaDto(
        @NotBlank
        String nome,

        @NotBlank
        String documento
) {
}

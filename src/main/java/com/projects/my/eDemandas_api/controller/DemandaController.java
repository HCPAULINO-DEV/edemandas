package com.projects.my.eDemandas_api.controller;

import com.projects.my.eDemandas_api.dto.CadastrarDemandaDto;
import com.projects.my.eDemandas_api.service.DemandaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/demandas")
public class DemandaController {

    private final DemandaService demandaService;

    public DemandaController(DemandaService demandaService) {
        this.demandaService = demandaService;
    }

    @PostMapping
    public ResponseEntity cadastrarDemanda(@RequestBody @Valid CadastrarDemandaDto dto, UriComponentsBuilder uriComponentsBuilder){
        var demandaSalva = demandaService.salvarDemanda(dto);
        var uri = uriComponentsBuilder.path("/demandas/{id}").buildAndExpand(demandaSalva.id()).toUri();

        return ResponseEntity.created(uri).body(demandaSalva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarDemanda(@PathVariable UUID id){
        demandaService.deletarDemanda(id);

        return ResponseEntity.noContent().build();
    }
}

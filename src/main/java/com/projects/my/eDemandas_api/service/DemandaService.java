package com.projects.my.eDemandas_api.service;

import com.projects.my.eDemandas_api.dto.CadastrarDemandaDto;
import com.projects.my.eDemandas_api.dto.InformarDemandaDto;
import com.projects.my.eDemandas_api.entity.Demanda;
import com.projects.my.eDemandas_api.entity.Status;
import com.projects.my.eDemandas_api.repository.DemandaRepository;
import org.springframework.stereotype.Service;

@Service
public class DemandaService {

    private final DemandaRepository demandaRepository;

    public DemandaService(DemandaRepository demandaRepository) {
        this.demandaRepository = demandaRepository;
    }

    public InformarDemandaDto salvarDemanda(CadastrarDemandaDto dto){
        Demanda demanda = new Demanda(dto);
        demanda.setStatus(Status.ABERTO);
        demandaRepository.save(demanda);

        return new InformarDemandaDto(
                demanda.getId().toString(),
                demanda.getNome(),
                demanda.getDocumento(),
                demanda.getStatus()
        );

    }
}

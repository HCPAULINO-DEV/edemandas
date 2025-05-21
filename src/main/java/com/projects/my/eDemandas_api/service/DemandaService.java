package com.projects.my.eDemandas_api.service;

import com.projects.my.eDemandas_api.dto.AtualizarDemandaDto;
import com.projects.my.eDemandas_api.dto.CadastrarDemandaDto;
import com.projects.my.eDemandas_api.dto.InformarDemandaDto;
import com.projects.my.eDemandas_api.entity.Demanda;
import com.projects.my.eDemandas_api.entity.Status;
import com.projects.my.eDemandas_api.infra.exception.DemandaNaoEncontradaExcpetion;
import com.projects.my.eDemandas_api.infra.exception.ExcluirDemandaStatusFinalizadoException;
import com.projects.my.eDemandas_api.repository.DemandaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DemandaService {

    private final DemandaRepository demandaRepository;

    public DemandaService(DemandaRepository demandaRepository) {
        this.demandaRepository = demandaRepository;
    }

    private Demanda obterDemandaOuExcpetion(UUID id){
        var demanda = demandaRepository.findById(id)
                .orElseThrow(() -> new DemandaNaoEncontradaExcpetion("Demanda com ID: " + id + " não encontrado."));

        return demanda;
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

    public void deletarDemanda(UUID id) {
        var demanda = obterDemandaOuExcpetion(id);
        if (demanda.getStatus() == Status.FINALIZADO){
            demandaRepository.delete(demanda);
        }
        else {
            throw new ExcluirDemandaStatusFinalizadoException("A demanda deve ter o status FINALIZADO para poder ser excluida!");
        }

    }

    public InformarDemandaDto atualizarDemanda(AtualizarDemandaDto dto, UUID id) {
        var demanda = obterDemandaOuExcpetion(id);
        demanda.atualizar(dto);
        demandaRepository.save(demanda);

        return new InformarDemandaDto(
                demanda.getId().toString(),
                demanda.getNome(),
                demanda.getDocumento(),
                demanda.getStatus()
        );
    }

    public Page<InformarDemandaDto> buscarDemandas(Pageable pageable){
        var demandas = demandaRepository.findAll(pageable);
        return demandas.map(InformarDemandaDto::new);
    }

}


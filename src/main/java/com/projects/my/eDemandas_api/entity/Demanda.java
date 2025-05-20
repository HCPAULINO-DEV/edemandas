package com.projects.my.eDemandas_api.entity;

import com.projects.my.eDemandas_api.dto.CadastrarDemandaDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "demanda")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Demanda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;
    private String documento;
    private Status status;

    public Demanda(CadastrarDemandaDto dto){
        this.nome = dto.nome();
        this.documento = dto.documento();
    }
}

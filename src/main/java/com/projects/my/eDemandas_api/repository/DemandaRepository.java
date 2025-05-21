package com.projects.my.eDemandas_api.repository;

import com.projects.my.eDemandas_api.entity.Demanda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface DemandaRepository extends JpaRepository<Demanda, UUID> {

    Page findByNome(String nome, Pageable pageable);
}

package com.acarb.repository;

import com.acarb.model.PrestadorDeServico;
import com.acarb.model.TipoServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestadorRepository extends JpaRepository<PrestadorDeServico, Long> {

    List<PrestadorDeServico> findByTipoServico(TipoServico tipoServico);

    PrestadorDeServico findByEmail(String email);
}
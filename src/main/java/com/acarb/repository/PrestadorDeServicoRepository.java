package com.acarb.repository;

import com.acarb.model.PrestadorDeServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestadorDeServicoRepository extends JpaRepository<PrestadorDeServico, Long> {
    // Métodos customizados podem ser adicionados aqui
}
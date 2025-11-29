package com.acarb.repository;

import com.acarb.model.AtendimentoDoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AtendimentoDoPedidoRepository extends JpaRepository<AtendimentoDoPedido, Long> {

    // Método de busca para o Controller, que corrigimos antes
    Optional<AtendimentoDoPedido> findByServicoPedidoIdServicoPedido(Long idPedido);
}
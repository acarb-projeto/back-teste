package com.acarb.repository;

import com.acarb.model.ServicoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ServicoPedidoRepository extends JpaRepository<ServicoPedido, Long> {

    // Método para buscar pedidos aceitos por um prestador específico
    List<ServicoPedido> findByPrestadorIdPrestador(Long idPrestador);

    // Método para buscar o pedido associado a uma solicitação (opcional)
    ServicoPedido findBySolicitacaoIdSolicitacao(Long idSolicitacao);
}
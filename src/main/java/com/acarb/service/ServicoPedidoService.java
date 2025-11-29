package com.acarb.service;

import com.acarb.model.ServicoPedido;
import com.acarb.model.SolicitacaoServico;
import com.acarb.model.StatusSolicitacao;
import com.acarb.repository.ServicoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional; // Necessário para findById

@Service
public class ServicoPedidoService {

    @Autowired
    private ServicoPedidoRepository servicoPedidoRepository;

    @Autowired
    private SolicitacaoServicoService solicitacaoService;

    /**
     * Lógica para um prestador aceitar um pedido de serviço.
     */
    public ServicoPedido aceitarServico(ServicoPedido pedido) {

        // 1. Salvar o pedido aceito pelo prestador.
        ServicoPedido novoPedido = servicoPedidoRepository.save(pedido);

        // 2. Atualizar o status da Solicitação (chave estrangeira)
        SolicitacaoServico solicitacao = novoPedido.getSolicitacao();
        if (solicitacao != null) {
            solicitacao.setStatus(StatusSolicitacao.PRESTADOR_ACEITOU);
            solicitacaoService.salvar(solicitacao); // Salva a atualização do status
        }

        return novoPedido;
    }

    /**
     * Método para atualizar o status do Pedido e da Solicitação associada,
     * usado por serviços externos (como AtendimentoDoPedidoService).
     */
    public Optional<ServicoPedido> buscarPorId(Long id) {
        // Note: Você pode precisar injetar o ServicoPedidoRepository no Service se ainda não o fez.
        return servicoPedidoRepository.findById(id);
    }
    public ServicoPedido atualizarStatus(Long idServicoPedido, StatusSolicitacao novoStatus) {

        Optional<ServicoPedido> pedidoOpt = servicoPedidoRepository.findById(idServicoPedido);

        if (pedidoOpt.isEmpty()) {
            throw new RuntimeException("Pedido de Serviço não encontrado com ID: " + idServicoPedido);
        }

        ServicoPedido pedido = pedidoOpt.get();

        // Atualiza o status da Solicitação (chave estrangeira)
        SolicitacaoServico solicitacao = pedido.getSolicitacao();
        if (solicitacao != null) {
            solicitacao.setStatus(novoStatus);
            solicitacaoService.salvar(solicitacao);
        }

        // 💡 NOTA: Não é necessário atualizar o ServicoPedido aqui, pois a mudança
        // de status principal ocorre na SolicitacaoServico e no AtendimentoDoPedido.

        return servicoPedidoRepository.save(pedido);
    }

    // ... você pode adicionar aqui outros métodos de busca (ex: buscarPorId, buscarTodos)
}
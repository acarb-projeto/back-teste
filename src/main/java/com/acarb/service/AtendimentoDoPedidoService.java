package com.acarb.service;

import com.acarb.model.AtendimentoDoPedido;
import com.acarb.model.ServicoPedido;
import com.acarb.model.StatusSolicitacao;
import com.acarb.repository.AtendimentoDoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AtendimentoDoPedidoService {
    public Optional<AtendimentoDoPedido> buscarPorServicoPedidoId(Long idPedido) {
        // Usamos o método definido no repositório no Passo 1
        return atendimentoRepository.findByServicoPedidoIdServicoPedido(idPedido);
    }

    @Autowired
    private AtendimentoDoPedidoRepository atendimentoRepository;

    @Autowired
    private ServicoPedidoService servicoPedidoService; // Para referência

    public AtendimentoDoPedido iniciarAtendimento(AtendimentoDoPedido atendimento) {
        // 💡 Lógica de negócio ao iniciar:
        // 1. O status inicial deve ser definido (ex: EM_ATENDIMENTO ou A_CAMINHO)
        atendimento.setStatusAtual(StatusSolicitacao.A_CAMINHO);
        atendimento.setHoraInicioAtendimento(LocalDateTime.now());

        // 2. O status da Solicitacao/Pedido também deve ser atualizado
        // (Isso requer um método de atualização no ServicoPedidoService ou acesso direto à SolicitacaoService)

        return atendimentoRepository.save(atendimento);
    }

    public AtendimentoDoPedido concluirAtendimento(AtendimentoDoPedido atendimento) {
        // 💡 Lógica de negócio ao concluir:
        // 1. Definir o status como CONCLUIDA
        atendimento.setStatusAtual(StatusSolicitacao.CONCLUIDA);
        atendimento.setHoraConclusaoServico(LocalDateTime.now());

        // 2. O status da Solicitacao/Pedido deve ser FINALIZADO
        // ... (lógica de atualização)

        return atendimentoRepository.save(atendimento);
    }

    // ... outros métodos de busca
}
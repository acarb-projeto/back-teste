package com.acarb.service;

import com.acarb.model.SolicitacaoServico;
import com.acarb.model.StatusSolicitacao;
import com.acarb.repository.SolicitacaoServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class SolicitacaoServicoService {

    // 1. INJEÇÃO DO REPOSITÓRIO (Correto: @Autowired na variável)
    @Autowired
    private SolicitacaoServicoRepository solicitacaoRepository;

    /**
     * Salva uma nova solicitação, definindo o status inicial como PENDENTE.
     */
    public SolicitacaoServico salvarNovaSolicitacao(SolicitacaoServico solicitacao) {
        // Lógica de negócio: define o status inicial
        solicitacao.setStatus(StatusSolicitacao.PENDENTE);
        return solicitacaoRepository.save(solicitacao);
    } // <--- CHAVE DE FECHAMENTO CORRETA

    /**
     * Salva ou atualiza uma solicitação existente (usado para mudar o status).
     * Este é o método que o ServicoPedidoService utiliza.
     */
    public SolicitacaoServico salvar(SolicitacaoServico solicitacao) {
        return solicitacaoRepository.save(solicitacao);
    }

    // --- Métodos de Busca ---

    public List<SolicitacaoServico> buscarTodos() {
        return solicitacaoRepository.findAll();
    }

    public Optional<SolicitacaoServico> buscarPorId(Long id) {
        return solicitacaoRepository.findById(id);
    }

    public List<SolicitacaoServico> buscarPendentes() {
        return solicitacaoRepository.findByStatus(StatusSolicitacao.PENDENTE);
    }
}
// OBS: Removida a linha de comentário que estava fora da chave de fechamento da classe.
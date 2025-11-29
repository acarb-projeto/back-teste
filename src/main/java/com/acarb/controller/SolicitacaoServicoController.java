package com.acarb.controller;

import com.acarb.model.SolicitacaoServico;
import com.acarb.service.SolicitacaoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/solicitacoes")
public class SolicitacaoServicoController {

    @Autowired
    private SolicitacaoServicoService solicitacaoService;

    // Endpoint para Motorista criar a solicitação
    @PostMapping("/criarSolicitacao")
    public ResponseEntity<SolicitacaoServico> criarSolicitacao(@RequestBody SolicitacaoServico solicitacao) {
        // 🔑 Motorista envia a solicitação, e o Service cuida da lógica (status, etc.)
        SolicitacaoServico novaSolicitacao = solicitacaoService.salvarNovaSolicitacao(solicitacao);
        return new ResponseEntity<>(novaSolicitacao, HttpStatus.CREATED);
    }

    // Endpoint para buscar todas as solicitações (útil para administradores)
    @GetMapping
    public ResponseEntity<List<SolicitacaoServico>> buscarTodos() {
        List<SolicitacaoServico> listaSolicitacoes = solicitacaoService.buscarTodos();
        return ResponseEntity.ok(listaSolicitacoes);
    }

    // Endpoint para Prestadores visualizarem as solicitações pendentes
    @GetMapping("/pendentes")
    public ResponseEntity<List<SolicitacaoServico>> buscarPendentes() {
        List<SolicitacaoServico> pendentes = solicitacaoService.buscarPendentes();
        return ResponseEntity.ok(pendentes);
    }
}
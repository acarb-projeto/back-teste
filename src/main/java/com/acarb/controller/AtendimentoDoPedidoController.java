package com.acarb.controller;

import com.acarb.model.AtendimentoDoPedido;
import com.acarb.service.AtendimentoDoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/atendimentos")
public class AtendimentoDoPedidoController {

    @Autowired
    private AtendimentoDoPedidoService atendimentoService;

    // Endpoint para Prestador iniciar o atendimento
    @PostMapping("/iniciar")
    public ResponseEntity<AtendimentoDoPedido> iniciar(@RequestBody AtendimentoDoPedido atendimento) {
        AtendimentoDoPedido novoAtendimento = atendimentoService.iniciarAtendimento(atendimento);
        return new ResponseEntity<>(novoAtendimento, HttpStatus.CREATED);
    }

    // Endpoint para Prestador concluir o atendimento
    @PutMapping("/concluir")
    public ResponseEntity<AtendimentoDoPedido> concluir(@RequestBody AtendimentoDoPedido atendimento) {
        AtendimentoDoPedido atendimentoConcluido = atendimentoService.concluirAtendimento(atendimento);
        return ResponseEntity.ok(atendimentoConcluido);
    }

    // Endpoint para buscar o atendimento pelo ID do pedido
    @GetMapping("/pedido/{idPedido}")
    public ResponseEntity<AtendimentoDoPedido> buscarPorPedidoId(@PathVariable Long idPedido) {
        return atendimentoService.buscarPorServicoPedidoId(idPedido) // <--- Chamada Corrigida
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
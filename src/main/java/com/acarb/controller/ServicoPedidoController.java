package com.acarb.controller;

import com.acarb.model.ServicoPedido;
import com.acarb.service.ServicoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class ServicoPedidoController {

    @Autowired
    private ServicoPedidoService servicoPedidoService;

    // Endpoint para Prestador aceitar uma solicitação e criar o pedido
    @PostMapping("/aceitar")
    public ResponseEntity<ServicoPedido> aceitarPedido(@RequestBody ServicoPedido pedido) {
        ServicoPedido novoPedido = servicoPedidoService.aceitarServico(pedido);
        return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
    }

    // Endpoint para buscar o pedido pelo ID
    @GetMapping("/{id}") // <-- Certifique-se de que é a linha 27 (ou onde o erro estava)
    public ResponseEntity<ServicoPedido> buscarPorId(@PathVariable Long id) {
        return servicoPedidoService.buscarPorId(id) // <--- Chamada corrigida
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
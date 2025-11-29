package com.acarb.controller;

import com.acarb.model.Oficina;
import com.acarb.service.OficinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/oficinas")
public class OficinaController {

    @Autowired
    private OficinaService oficinaService;

    // Endpoint para registrar uma nova oficina
    @PostMapping("/cadastro")
    public ResponseEntity<Oficina> cadastrarOficina(@RequestBody Oficina oficina) {
        Oficina novaOficina = oficinaService.salvarOficina(oficina);
        return new ResponseEntity<>(novaOficina, HttpStatus.CREATED);
    }

    // Endpoint para buscar todas as oficinas
    @GetMapping
    public ResponseEntity<List<Oficina>> listarTodas() {
        return ResponseEntity.ok(oficinaService.listarTodos()); // <--- Chamada corrigida
    }

    // ... outros endpoints (busca por ID, atualização)
}
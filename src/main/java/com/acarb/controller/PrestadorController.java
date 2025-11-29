package com.acarb.controller;

import com.acarb.model.PrestadorDeServico;
import com.acarb.model.TipoServico;
import com.acarb.service.PrestadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marca a classe como um Controller REST
@RequestMapping("/api/prestadores") // URL base
public class PrestadorController {

    private final PrestadorService prestadorService;

    // Injeção de Dependência
    @Autowired
    public PrestadorController(PrestadorService prestadorService) {
        this.prestadorService = prestadorService;
    }

    /**
     * Endpoint para REGISTRAR um novo Prestador de Serviço.
     * Método: POST
     * URL: /api/prestadores
     */
    @PostMapping
    public ResponseEntity<PrestadorDeServico> registrarPrestador(@RequestBody PrestadorDeServico prestador) {
        PrestadorDeServico novoPrestador = prestadorService.salvarPrestador(prestador);
        // Retorna o status 201 CREATED
        return new ResponseEntity<>(novoPrestador, HttpStatus.CREATED);
    }

    /**
     * Endpoint para BUSCAR todos os prestadores ou filtrar por tipo.
     * Método: GET
     * URL: /api/prestadores (busca todos)
     * URL: /api/prestadores?tipo=MECANICO (busca por tipo)
     */
    @GetMapping
    public ResponseEntity<List<PrestadorDeServico>> listarPrestadores(
            // @RequestParam permite filtrar por um parâmetro de URL (opcional)
            @RequestParam(required = false) TipoServico tipo) {

        List<PrestadorDeServico> prestadores;

        if (tipo != null) {
            // Se o parâmetro 'tipo' foi fornecido
            prestadores = prestadorService.buscarPorTipo(tipo);
        } else {
            // Se nenhum parâmetro foi fornecido
            prestadores = prestadorService.buscarTodos();
        }

        // Retorna o status 200 OK e a lista de prestadores
        return new ResponseEntity<>(prestadores, HttpStatus.OK);
    }
}

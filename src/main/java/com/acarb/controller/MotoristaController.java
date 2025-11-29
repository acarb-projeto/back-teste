package com.acarb.controller;

import com.acarb.model.Motorista;
import com.acarb.service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motoristas")
public class MotoristaController {

    private final MotoristaService motoristaService;

    @Autowired
    public MotoristaController(MotoristaService motoristaService) {
        this.motoristaService = motoristaService;
    }

    @PostMapping
    public ResponseEntity<Motorista> registrarMotorista(@RequestBody Motorista motorista) {
        Motorista novoMotorista = motoristaService.salvarMotorista(motorista);
        return new ResponseEntity<>(novoMotorista, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Motorista>> listarMotoristas() {
        List<Motorista> motoristas = motoristaService.buscarTodos();
        return new ResponseEntity<>(motoristas, HttpStatus.OK);
    }
}
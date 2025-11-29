package com.acarb.controller;

import com.acarb.model.Login;
import com.acarb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth") // auth = autenticação
public class LoginController {

    @Autowired
    private LoginService loginService;

    // Endpoint para registro de login (usado após o cadastro do Motorista/Prestador)
    @PostMapping("/registrar")
    public ResponseEntity<Login> registrarLogin(@RequestBody Login login) {
        Login novoLogin = loginService.registrarNovoLogin(login);
        return new ResponseEntity<>(novoLogin, HttpStatus.CREATED);
    }

    // O endpoint de login (POST /api/auth/login) será configurado no Spring Security
    // (com filtros e providers, e não aqui)
}
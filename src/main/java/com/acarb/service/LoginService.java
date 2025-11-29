package com.acarb.service;

import com.acarb.model.Login;
import com.acarb.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder; // Você precisará desta dependência
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Será injetado pelo Spring Security

    public Login registrarNovoLogin(Login login) {

        // 💡 PASSO CRÍTICO: Criptografar a senha antes de salvar no banco
        String senhaCriptografada = passwordEncoder.encode(login.getSenhaHash());
        login.setSenhaHash(senhaCriptografada);

        return loginRepository.save(login);
    }

    public Optional<Login> buscarPorEmail(String email) {
        return loginRepository.findByEmail(email);
    }
}
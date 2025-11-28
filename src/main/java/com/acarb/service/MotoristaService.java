package com.acarb.service;

import com.acarb.model.Motorista;
import com.acarb.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder; // NOVO IMPORT

import java.util.List;

@Service
public class MotoristaService {

    private final MotoristaRepository motoristaRepository;
    private final PasswordEncoder passwordEncoder; // NOVO CAMPO

    @Autowired
    public MotoristaService(MotoristaRepository motoristaRepository, PasswordEncoder passwordEncoder) {
        this.motoristaRepository = motoristaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Motorista salvarMotorista(Motorista motorista) {
        String senhaCriptografada = passwordEncoder.encode(motorista.getSenha());
        motorista.setSenha(senhaCriptografada);

        return motoristaRepository.save(motorista);
    }

    public List<Motorista> buscarTodos() {
        return motoristaRepository.findAll();
    }
}
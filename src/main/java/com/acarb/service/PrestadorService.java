package com.acarb.service;

import com.acarb.model.PrestadorDeServico;
import com.acarb.model.TipoServico;
import com.acarb.repository.PrestadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder; // NOVO IMPORT

import java.util.List;

@Service
public class PrestadorService {

    private final PrestadorRepository prestadorRepository;
    private final PasswordEncoder passwordEncoder; // NOVO CAMPO

    @Autowired
    public PrestadorService(PrestadorRepository prestadorRepository, PasswordEncoder passwordEncoder) {
        this.prestadorRepository = prestadorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public PrestadorDeServico salvarPrestador(PrestadorDeServico prestador) {
        String senhaCriptografada = passwordEncoder.encode(prestador.getSenha());
        prestador.setSenha(senhaCriptografada);

        return prestadorRepository.save(prestador);
    }

    public List<PrestadorDeServico> buscarTodos() {
        return prestadorRepository.findAll();
    }

    public List<PrestadorDeServico> buscarPorTipo(TipoServico tipoServico) {
        return prestadorRepository.findByTipoServico(tipoServico);
    }
}
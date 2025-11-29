package com.acarb.service;

import com.acarb.model.PrestadorDeServico;
import com.acarb.repository.PrestadorDeServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrestadorDeServicoService {

    @Autowired
    private PrestadorDeServicoRepository prestadorDeServicoRepository;

    /**
     * Salva um novo Prestador de Serviço.
     * Este é o método que está sendo chamado pelo OficinaService.
     */
    public PrestadorDeServico salvarPrestador(PrestadorDeServico prestador) {
        return prestadorDeServicoRepository.save(prestador);
    }

    // Você pode adicionar outros métodos de busca (ex: buscarPorId, buscarTodos) aqui, se precisar.
}

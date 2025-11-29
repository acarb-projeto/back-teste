package com.acarb.service;

import com.acarb.model.Oficina;
import com.acarb.model.PrestadorDeServico;
import com.acarb.repository.OficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.acarb.service.PrestadorDeServicoService;
import java.util.Optional;

@Service
public class OficinaService {

    @Autowired
    private OficinaRepository oficinaRepository;

    @Autowired
    private PrestadorDeServicoService prestadorDeServicoService;

    /**
     * Salva uma nova Oficina e registra o Prestador de Serviço associado.
     */
    public Oficina salvarOficina(Oficina oficina) {
        // 1. Garante que o Prestador de Serviço da Oficina seja salvo primeiro
        PrestadorDeServico prestador = oficina.getPrestador();
        if (prestador != null) {
            PrestadorDeServico prestadorSalvo = prestadorDeServicoService.salvarPrestador(prestador);
            oficina.setPrestador(prestadorSalvo);
        }

        // 2. Salva a Oficina
        return oficinaRepository.save(oficina);
    } // <--- CHAVE DE FECHAMENTO DO MÉTODO SALVAROFICINA

    /**
     * Busca todas as oficinas cadastradas.
     */
    public List<Oficina> listarTodos() {
        return oficinaRepository.findAll();
    } // <--- CHAVE DE FECHAMENTO DO MÉTODO LISTARTODOS

    // Você pode adicionar aqui buscarPorId, atualizar, etc.

    // public Optional<Oficina> buscarPorId(Long id) {
    //     return oficinaRepository.findById(id);
    // }
} // <--- CHAVE DE FECHAMENTO DA CLASSE
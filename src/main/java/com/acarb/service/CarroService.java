package com.acarb.service;

import com.acarb.model.Carro;
import com.acarb.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public Carro salvar(Carro carro) {
        // 💡 Lógica de negócio: Validar placa, verificar se o motorista existe, etc.
        return carroRepository.save(carro);
    }

    public List<Carro> buscarTodos() {
        return carroRepository.findAll();
    }

    public Optional<Carro> buscarPorId(Long id) {
        return carroRepository.findById(id);
    }

    // 💡 Exemplo de método customizado
    // public List<Carro> buscarPorMotorista(Long idMotorista) {
    //     return carroRepository.findByMotoristaIdMotorista(idMotorista);
    // }
}
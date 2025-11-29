package com.acarb.repository;

import com.acarb.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    // Você pode adicionar métodos customizados aqui, como:
    // List<Carro> findByMotoristaIdMotorista(Long idMotorista);
}
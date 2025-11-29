package com.acarb.repository;

import com.acarb.model.Oficina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface OficinaRepository extends JpaRepository<Oficina, Long> {

    // Método para buscar uma oficina pelo CNPJ
    Optional<Oficina> findByCnpj(String cnpj);
}
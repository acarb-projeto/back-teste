package com.acarb.repository;

import com.acarb.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

    // Método essencial para autenticação: buscar o registro pelo email
    Optional<Login> findByEmail(String email);

    // Método para verificar se um usuário já tem um registro de login
    Optional<Login> findByUsuarioIdUsuario(Long idUsuario);
}
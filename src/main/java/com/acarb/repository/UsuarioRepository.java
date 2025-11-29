package com.acarb.repository;

import com.acarb.model.Usuario;
import com.acarb.model.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método customizado que será útil para o Login/Autenticação
    Optional<Usuario> findByEmail(String email);

    // Método para buscar usuários por tipo e id_origem (sua indexação SQL)
    Optional<Usuario> findByTipoAndIdOrigem(TipoUsuario tipo, Long idOrigem);
}
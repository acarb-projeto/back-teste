package com.acarb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "login") // Nome da tabela no MySQL
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_login")
    private Long idLogin;

    // Relacionamento One-to-One: Cada Login pertence a UM Usuário (via FK id_usuario_fk)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_fk", referencedColumnName = "id_usuario")
    private Usuario usuario; // A model Usuario precisa existir no seu projeto

    @Column(name = "senha_hash", nullable = false)
    private String senhaHash; // Senha criptografada (NUNCA a senha em texto claro!)

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "ultimo_acesso")
    private LocalDateTime ultimoAcesso;

    // ... Getters e Setters
}
package com.acarb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "usuario") // Nome exato da tabela no MySQL
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    // Mapeamento do ENUM (tipo)
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoUsuario tipo;

    @Column(name = "id_origem", nullable = false) // ID da tabela referenciada (Motorista, Prestador, etc.)
    private Long idOrigem;

    private String nome;
    private String email;
    private String telefone;

    // Mapeamento para Perfil (Você precisará criar a classe Perfil depois)
    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_perfil_fk")
    private Perfil perfil;
    */

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // 💡 Adicione Construtores, Getters e Setters aqui
}

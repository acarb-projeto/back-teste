package com.acarb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "carro") // Nome exato da tabela no MySQL
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carro")
    private Long idCarro;

    // Relacionamento Many-to-One: Um carro pertence a um Motorista
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_motorista_fk", referencedColumnName = "id_motorista")
    private Motorista motorista; // Note que Motorista precisa existir no pacote 'model'

    private String placa;
    private String modelo;
    private String marca;
    private Integer ano;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // 💡 Adicione Construtores, Getters e Setters aqui
}
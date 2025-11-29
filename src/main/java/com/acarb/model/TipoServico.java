package com.acarb.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data// 🔑 Precisa ser uma Entity (classe)
@Table(name = "tipo_servico")
public class TipoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_servico")
    private Long idTipoServico;

    private String nome;
    private String descricao;

    // Construtores, Getters e Setters (pressione Alt+Insert / Cmd+N para gerar)
}
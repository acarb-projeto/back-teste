package com.acarb.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "prestador_de_servico")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrestadorDeServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(length = 20)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoServico tipoServico;


    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;


    private Double avaliacaoMedia = 0.0;

    private Integer totalAvaliacoes = 0;
}
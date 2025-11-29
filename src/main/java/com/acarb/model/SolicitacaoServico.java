package com.acarb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "solicitacao_servico") // Nome da tabela no MySQL
public class SolicitacaoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitacao")
    private Long idSolicitacao;

    // Relacionamento Many-to-One: A solicitação é feita por um Motorista
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_motorista_fk", referencedColumnName = "id_motorista")
    private Motorista motorista;

    // Relacionamento Many-to-One: A solicitação é sobre um Carro
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carro_fk", referencedColumnName = "id_carro")
    private Carro carro;

    // Relacionamento Many-to-One: O tipo de serviço
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_servico_fk", referencedColumnName = "id_tipo_servico")
    private TipoServico tipoServico;

    // Status da solicitação (usando a Enum criada acima)
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusSolicitacao status;

    // Detalhes da Localização da Ocorrência
    @Column(name = "latitude_origem")
    private Double latitudeOrigem;

    @Column(name = "longitude_origem")
    private Double longitudeOrigem;

    @Column(name = "observacoes")
    private String observacoes;

    @Column(name = "data_hora_solicitacao", nullable = false)
    private LocalDateTime dataHoraSolicitacao = LocalDateTime.now();

    // 💡 Adicione Construtores, Getters e Setters
}
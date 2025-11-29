package com.acarb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "atendimento_do_pedido")
@Data// Nome da tabela no MySQL
public class AtendimentoDoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atendimento")
    private Long idAtendimento;

    // Relacionamento One-to-One: O atendimento é para UM ServicoPedido específico
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_servico_pedido_fk", referencedColumnName = "id_servico_pedido")
    private ServicoPedido servicoPedido;

    // Acompanha a etapa atual (pode ser um ENUM customizado, ou usar o StatusSolicitacao)
    @Enumerated(EnumType.STRING)
    @Column(name = "status_atual")
    private StatusSolicitacao statusAtual;

    // Campos de tempo para rastreio
    @Column(name = "hora_inicio_atendimento")
    private LocalDateTime horaInicioAtendimento;

    @Column(name = "hora_conclusao_servico")
    private LocalDateTime horaConclusaoServico;

    // Localização final do serviço (destino do reboque, por exemplo)
    @Column(name = "latitude_destino")
    private Double latitudeDestino;

    @Column(name = "longitude_destino")
    private Double longitudeDestino;

    // Observações finais, laudo, etc.
    private String laudoServico;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    // 💡 Adicione Construtores, Getters e Setters
}

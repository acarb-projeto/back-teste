package com.acarb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "servico_pedido")// Nome da tabela no MySQL
public class ServicoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servico_pedido")
    private Long idServicoPedido;

    // Relacionamento One-to-One: Um pedido formal é para UMA solicitação
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_solicitacao_fk", referencedColumnName = "id_solicitacao")
    private SolicitacaoServico solicitacao; // Campo que precisa do getter

    // Relacionamento Many-to-One: O pedido é atendido por UM Prestador
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prestador_fk", referencedColumnName = "id_prestador")
    private PrestadorDeServico prestador;

    @Column(name = "valor_proposto")
    private Double valorProposto;

    @Column(name = "data_aceitacao")
    private LocalDateTime dataAceitacao = LocalDateTime.now();

    // Outros campos importantes:
    private String observacoesPrestador;

    // --- GETTERS & SETTERS ADICIONADOS ---

    // Este Getter corrige o erro 'cannot find symbol method getSolicitacao()'
    public SolicitacaoServico getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(SolicitacaoServico solicitacao) {
        this.solicitacao = solicitacao;
    }

    // Você deve adicionar todos os outros Getters/Setters necessários para os outros campos
    // (idServicoPedido, prestador, valorProposto, dataAceitacao, observacoesPrestador)

    // Exemplo de outro getter
    public Long getIdServicoPedido() {
        return idServicoPedido;
    }

    // ... (restante dos getters e setters)
}
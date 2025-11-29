package com.acarb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "oficina") // Nome da tabela no MySQL
public class Oficina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oficina")
    private Long idOficina;

    // Relacionamento One-to-One: Cada oficina é um PrestadorDeServico
    // Usamos o @JoinColumn para mapear a FK: id_prestador_fk
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prestador_fk", referencedColumnName = "id_prestador")
    private PrestadorDeServico prestador;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    private String cnpj;

    @Column(name = "telefone_fixo")
    private String telefoneFixo;

    // Campos adicionais específicos de oficina
    @Column(name = "especialidade")
    private String especialidade;

    // ... Campos de data/hora

    // 💡 Adicione Construtores, Getters e Setters
}

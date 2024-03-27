package com.br.pontoInteligente.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "MARCACAO_TIPO")
public class MarcacaoTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "TEMPO_RECOMENDADO_MINUTOS")
    private Long tempoRecomendadoMinutos;
}
package com.br.pontoInteligente.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "MARCACAO_VINCULO_INICIO_FIM")
public class MarcacaoVinculoInicioFim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @OneToOne
    @JoinColumn(name = "COD_MARCACAO_INICIO", unique = true, nullable = false)
    private Marcacao marcacaoInicio;

    @OneToOne
    @JoinColumn(name = "COD_MARCACAO_FIM", unique = true, nullable = false)
    private Marcacao marcacaoFim;
}
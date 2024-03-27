package com.br.pontoInteligente.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "MARCACAO")
public class Marcacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "COD_TIPO_MARCACAO", nullable = false)
    private MarcacaoTipo marcacaoTipo;

    @ManyToOne
    @JoinColumn(name = "CPF_COLABORADOR", nullable = false)
    private Colaborador colaborador;

    @Column(name = "DATA_HORA_MARCACAO", nullable = false)
    private LocalDateTime dataHoraMarcacao;

    @Column(name = "TIPO_MARCACAO", nullable = false)
    private String tipoMarcacao;
}
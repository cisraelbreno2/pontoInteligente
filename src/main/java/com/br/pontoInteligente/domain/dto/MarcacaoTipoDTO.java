package com.br.pontoInteligente.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarcacaoTipoDTO {

    private long codigo;
    private String nome;
    private String tempoRecomendado;
    private String totalPeriodo;
    private String horasNoturnasCLT;
}
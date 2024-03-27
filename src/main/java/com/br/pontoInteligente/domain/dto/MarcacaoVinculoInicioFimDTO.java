package com.br.pontoInteligente.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MarcacaoVinculoInicioFimDTO {

    private long tipo;
    private MarcacaoDTO marcacaoInicio;
    private MarcacaoDTO marcacaoFim;
}
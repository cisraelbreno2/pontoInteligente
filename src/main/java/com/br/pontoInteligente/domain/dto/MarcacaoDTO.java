package com.br.pontoInteligente.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MarcacaoDTO {

    public long codMarcacaoTipo;
    private String data;
    private String hora;

}

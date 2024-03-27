package com.br.pontoInteligente.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DiaDTO {

    private String data;
    private List<MarcacaoVinculoInicioFimDTO> marcacao;
}
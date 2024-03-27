package com.br.pontoInteligente.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RelatorioDTO {

    private String periodo;
    private String dataGeracao;
    private String colaborador;
    private List<DiaDTO> listaDias;
    private List<MarcacaoTipoDTO> listaMarcacaoTipo;
}
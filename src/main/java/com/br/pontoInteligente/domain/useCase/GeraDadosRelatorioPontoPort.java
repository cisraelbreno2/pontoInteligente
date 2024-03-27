package com.br.pontoInteligente.domain.useCase;

import com.br.pontoInteligente.domain.dto.RelatorioDTO;

public interface GeraDadosRelatorioPontoPort {

    RelatorioDTO geraRelatorio(String dataInicio, String dataFim, String cpfColaborador);
}

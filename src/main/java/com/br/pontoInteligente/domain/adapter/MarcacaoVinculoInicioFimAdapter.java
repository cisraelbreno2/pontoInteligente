package com.br.pontoInteligente.domain.adapter;

import com.br.pontoInteligente.domain.model.MarcacaoVinculoInicioFim;

import java.time.LocalDateTime;
import java.util.List;

public interface MarcacaoVinculoInicioFimAdapter {
    List<MarcacaoVinculoInicioFim> buscaVinculoInicioFimPorData(LocalDateTime dataInicial, LocalDateTime dataFinal, String cpfColaborador);
}

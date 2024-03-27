package com.br.pontoInteligente.domain.adapter;

import com.br.pontoInteligente.domain.model.Marcacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface MarcacaoAdapter {

    List<Marcacao> buscaMarcacaoPorData(LocalDateTime localDateTime, LocalDateTime localDateTime1, String cpfColaborador);
}

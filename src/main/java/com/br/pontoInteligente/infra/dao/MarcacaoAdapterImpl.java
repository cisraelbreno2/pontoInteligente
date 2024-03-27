package com.br.pontoInteligente.infra.dao;

import com.br.pontoInteligente.domain.adapter.MarcacaoAdapter;
import com.br.pontoInteligente.domain.model.Marcacao;
import com.br.pontoInteligente.infra.repository.MarcacaoRepository;
import com.br.pontoInteligente.infra.standard.AbstractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MarcacaoAdapterImpl extends AbstractRepository implements MarcacaoAdapter {

    private final MarcacaoRepository marcacaoRepository;

    @Override
    public List<Marcacao> buscaMarcacaoPorData(LocalDateTime localDateTime, LocalDateTime localDateTime1, String cpfColaborador) {
        return marcacaoRepository.buscaMarcacaoPorData(localDateTime, localDateTime1, cpfColaborador);
    }
}

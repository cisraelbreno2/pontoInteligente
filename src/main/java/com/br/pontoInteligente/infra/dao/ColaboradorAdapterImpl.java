package com.br.pontoInteligente.infra.dao;

import com.br.pontoInteligente.domain.adapter.ColaboradorAdapter;
import com.br.pontoInteligente.infra.repository.ColaboradorRepository;
import com.br.pontoInteligente.infra.standard.AbstractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ColaboradorAdapterImpl extends AbstractRepository implements ColaboradorAdapter  {

    private final ColaboradorRepository colaboradorRepository;

    @Override
    public String buscaColaboradorPorCpf(String cpfColaborador) {
        return colaboradorRepository.buscaNomeColaboradorPorCpf(cpfColaborador);
    }
}

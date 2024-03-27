package com.br.pontoInteligente.infra.dao;

import com.br.pontoInteligente.domain.adapter.MarcacaoVinculoInicioFimAdapter;
import com.br.pontoInteligente.domain.model.MarcacaoVinculoInicioFim;
import com.br.pontoInteligente.infra.repository.MarcacaoVinculoInicioFimRepository;
import com.br.pontoInteligente.infra.standard.AbstractRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@AllArgsConstructor
public class MarcacaoVinculoInicioFimAdapterImpl extends AbstractRepository implements MarcacaoVinculoInicioFimAdapter {

    private final MarcacaoVinculoInicioFimRepository marcacaoVinculoInicioFimRepository;

    @Override
    public List<MarcacaoVinculoInicioFim> buscaVinculoInicioFimPorData(LocalDateTime dataInicial, LocalDateTime dataFinal, String cpfColaborador) {
        return marcacaoVinculoInicioFimRepository.buscaVinculoInicioFimPorData(dataInicial, dataFinal, cpfColaborador);
    }
}

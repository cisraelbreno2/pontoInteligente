package com.br.pontoInteligente.infra.dao;

import com.br.pontoInteligente.domain.adapter.MarcacaoTipoAdapter;
import com.br.pontoInteligente.domain.model.MarcacaoTipo;
import com.br.pontoInteligente.infra.repository.MarcacaoTipoRepository;
import com.br.pontoInteligente.infra.standard.AbstractRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MarcacaoTipoAdapterImpl extends AbstractRepository implements MarcacaoTipoAdapter {

    private final MarcacaoTipoRepository marcacaoTipoRepository;

    @Override
    public List<MarcacaoTipo> buscaTudoMarcacaoTipo() {
        return marcacaoTipoRepository.findAll();
    }
}

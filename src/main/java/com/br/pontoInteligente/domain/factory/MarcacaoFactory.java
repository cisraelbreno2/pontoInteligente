package com.br.pontoInteligente.domain.factory;

import com.br.pontoInteligente.domain.dto.MarcacaoDTO;
import com.br.pontoInteligente.domain.model.Marcacao;
import com.br.pontoInteligente.domain.util.DateUtils;

public class MarcacaoFactory {

    public static MarcacaoDTO criaMarcacao(Marcacao marcacao){
        return new MarcacaoDTO(marcacao.getMarcacaoTipo().getCodigo(), DateUtils.formatarData(marcacao.getDataHoraMarcacao()), DateUtils.formatarHora(marcacao.getDataHoraMarcacao()));
    }
}

package com.br.pontoInteligente.domain.factory;

import com.br.pontoInteligente.domain.dto.DiaDTO;
import com.br.pontoInteligente.domain.dto.MarcacaoVinculoInicioFimDTO;
import com.br.pontoInteligente.domain.enuns.TipoMarcacaoEnum;
import com.br.pontoInteligente.domain.model.Marcacao;
import com.br.pontoInteligente.domain.model.MarcacaoVinculoInicioFim;
import com.br.pontoInteligente.domain.util.DateUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MarcacaoVinculoInicioFimFactory {

    public static List<DiaDTO> criaDia(List<MarcacaoVinculoInicioFim> listaMarcacaoVinculoInicioFim, List<Marcacao> listaMarcacao){
        List<String> listaDia = new ArrayList<>(listaMarcacaoVinculoInicioFim.stream().map(m -> DateUtils.formatarData(m.getMarcacaoInicio().getDataHoraMarcacao())).distinct().toList());
        listaDia.addAll(listaMarcacao.stream().map(m -> DateUtils.formatarData(m.getDataHoraMarcacao())).distinct().toList());

        List<DiaDTO> listaDiaDTO = new ArrayList<>();

        listaDia.forEach(dia -> {
            List<MarcacaoVinculoInicioFimDTO> listaMarcacaoVinculoInicioFimDTO = new ArrayList<>();

            listaMarcacaoVinculoInicioFim.stream().filter(m -> DateUtils.formatarData(m.getMarcacaoInicio().getDataHoraMarcacao()).equals(dia)).toList().forEach(m -> {
                listaMarcacaoVinculoInicioFimDTO.add(createMarcacaoVinculoInicioFimDTO(m));
            });
            listaMarcacao.stream().filter(m -> DateUtils.formatarData(m.getDataHoraMarcacao()).equals(dia)).toList().forEach(m -> {
                listaMarcacaoVinculoInicioFimDTO.add(createMarcacaoVinculoInicioFimDTO(m));
            });

            listaDiaDTO.add(new DiaDTO(dia, listaMarcacaoVinculoInicioFimDTO));
        });

        return listaDiaDTO;
    }

    public static MarcacaoVinculoInicioFimDTO createMarcacaoVinculoInicioFimDTO(MarcacaoVinculoInicioFim marcacaoVinculoInicioFim) {
        Marcacao marcacaoInicio = marcacaoVinculoInicioFim.getMarcacaoInicio();
        Marcacao marcacaoFim = marcacaoVinculoInicioFim.getMarcacaoFim();

        return new MarcacaoVinculoInicioFimDTO(
                marcacaoInicio != null ? marcacaoInicio.getMarcacaoTipo().getCodigo() : marcacaoFim.getMarcacaoTipo().getCodigo(),
                marcacaoInicio != null ? MarcacaoFactory.criaMarcacao(marcacaoInicio) : null,
                marcacaoFim != null ? MarcacaoFactory.criaMarcacao(marcacaoFim) : null
        );
    }

    public static MarcacaoVinculoInicioFimDTO createMarcacaoVinculoInicioFimDTO(Marcacao marcacao){
        if(marcacao.getTipoMarcacao().equals(TipoMarcacaoEnum.MARCACAO_INICIO.name())){
            return new MarcacaoVinculoInicioFimDTO(marcacao.getMarcacaoTipo().getCodigo(), MarcacaoFactory.criaMarcacao(marcacao), null);
        }else{
            return new MarcacaoVinculoInicioFimDTO(marcacao.getMarcacaoTipo().getCodigo(), null, MarcacaoFactory.criaMarcacao(marcacao));
        }

    }
}

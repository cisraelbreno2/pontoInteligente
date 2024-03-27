package com.br.pontoInteligente.domain.useCase.impl;

import com.br.pontoInteligente.domain.adapter.ColaboradorAdapter;
import com.br.pontoInteligente.domain.adapter.MarcacaoAdapter;
import com.br.pontoInteligente.domain.adapter.MarcacaoTipoAdapter;
import com.br.pontoInteligente.domain.adapter.MarcacaoVinculoInicioFimAdapter;
import com.br.pontoInteligente.domain.annotation.UseCase;
import com.br.pontoInteligente.domain.dto.MarcacaoTipoDTO;
import com.br.pontoInteligente.domain.dto.RelatorioDTO;
import com.br.pontoInteligente.domain.exception.GeraDadosRelatorioPontoException;
import com.br.pontoInteligente.domain.factory.MarcacaoVinculoInicioFimFactory;
import com.br.pontoInteligente.domain.model.MarcacaoVinculoInicioFim;
import com.br.pontoInteligente.domain.useCase.GeraDadosRelatorioPontoPort;
import com.br.pontoInteligente.domain.util.CpfUtils;
import com.br.pontoInteligente.domain.util.DateUtils;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.br.pontoInteligente.domain.util.DateUtils.*;

@UseCase
@AllArgsConstructor
public class GeraDadosRelatorioPontoUseCase implements GeraDadosRelatorioPontoPort {

    private final MarcacaoTipoAdapter marcacaoTipoAdapter;
    private final ColaboradorAdapter colaboradorAdapter;
    private final MarcacaoVinculoInicioFimAdapter marcacaoVinculoInicioFimAdapter;
    private final MarcacaoAdapter marcacaoAdapter;

    @Override
    public RelatorioDTO geraRelatorio(String dataInicio, String dataFim, String cpfColaborador) {

        LocalDate dataInicial = DateUtils.parse(dataInicio);
        LocalDate dataFinal = DateUtils.parse(dataFim);

        if(!CpfUtils.validar(cpfColaborador)){
            throw new GeraDadosRelatorioPontoException("CPF inválido");
        }

        if(dataInicial.isAfter(dataFinal)){
            throw new GeraDadosRelatorioPontoException("Data inicial deve ser menor que a data final");
        }

        var nomeColaborador = colaboradorAdapter.buscaColaboradorPorCpf(cpfColaborador);

        var listaMarcacaoVinculoInicioFim = marcacaoVinculoInicioFimAdapter.buscaVinculoInicioFimPorData(dataInicial.atStartOfDay(), dataFinal.plusDays(1).atStartOfDay(), cpfColaborador);
        var listaMarcacao = marcacaoAdapter.buscaMarcacaoPorData(dataInicial.atStartOfDay(), dataFinal.plusDays(1).atStartOfDay(), cpfColaborador);

        var listaDias = MarcacaoVinculoInicioFimFactory.criaDia(listaMarcacaoVinculoInicioFim, listaMarcacao);

        return RelatorioDTO.builder()
                .periodo(formatarData(dataInicial)  + " - " + formatarData(dataFinal))
                .dataGeracao(formatarDataHora(LocalDateTime.now()))
                .colaborador(nomeColaborador)
                .listaDias(listaDias)
                .listaMarcacaoTipo(calcularHorasTrabalhadas(listaMarcacaoVinculoInicioFim))
                .build();
    }


    public List<MarcacaoTipoDTO>  calcularHorasTrabalhadas(List<MarcacaoVinculoInicioFim> listaMarcacaoVinculoInicioFim){
        var listaMarcacaoTipo = marcacaoTipoAdapter.buscaTudoMarcacaoTipo();
        var listaMarcacaoTipoDTO = new ArrayList<MarcacaoTipoDTO>();

        listaMarcacaoTipo.forEach(marcacaoTipo -> {
            long quantidadeSegundos = listaMarcacaoVinculoInicioFim.stream()
                    .filter(m -> m.getMarcacaoInicio() != null && m.getMarcacaoFim() != null)
                    .filter(m -> m.getMarcacaoInicio().getMarcacaoTipo().getCodigo().equals(marcacaoTipo.getCodigo()))
                    .mapToLong(m -> calcularDiferencaSegundos(m.getMarcacaoInicio().getDataHoraMarcacao(), m.getMarcacaoFim().getDataHoraMarcacao()))
                    .sum();

            listaMarcacaoTipoDTO.add(new MarcacaoTipoDTO(
                    marcacaoTipo.getCodigo(),
                    marcacaoTipo.getNome(),
                    formatarMinutos(marcacaoTipo.getTempoRecomendadoMinutos()),
                    formatarSegundos(quantidadeSegundos),
                    ""));
        });

        return listaMarcacaoTipoDTO;
    }
}

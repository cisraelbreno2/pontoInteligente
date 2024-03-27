package com.br.pontoInteligente.infra.repository;

import com.br.pontoInteligente.domain.model.MarcacaoVinculoInicioFim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface MarcacaoVinculoInicioFimRepository extends JpaRepository<MarcacaoVinculoInicioFim, Long> {

    @Query("SELECT mvif FROM MarcacaoVinculoInicioFim mvif " +
            "LEFT JOIN mvif.marcacaoInicio minicio " +
            "LEFT JOIN mvif.marcacaoFim mfim " +
            "RIGHT JOIN Colaborador c ON c.cpf = mfim.colaborador.cpf OR c.cpf = minicio.colaborador.cpf " +
            "WHERE c.cpf = :cpfColaborador AND " +
            "      (minicio.dataHoraMarcacao IS NULL OR minicio.dataHoraMarcacao >= :dataInicial) AND " +
            "      (mfim.dataHoraMarcacao IS NULL OR mfim.dataHoraMarcacao <= :dataFinal) " +
            "ORDER BY minicio.dataHoraMarcacao, mfim.dataHoraMarcacao")
    List<MarcacaoVinculoInicioFim> buscaVinculoInicioFimPorData(LocalDateTime dataInicial, LocalDateTime dataFinal, String cpfColaborador);
}

package com.br.pontoInteligente.infra.repository;

import com.br.pontoInteligente.domain.model.Marcacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface MarcacaoRepository extends JpaRepository<Marcacao, Long> {

    @Query("SELECT m FROM Marcacao m " +
            "WHERE NOT EXISTS ( " +
            "    SELECT 1 FROM MarcacaoVinculoInicioFim mvif " +
            "    WHERE mvif.marcacaoInicio.codigo = m.codigo OR mvif.marcacaoFim.codigo = m.codigo " +
            "    AND m.colaborador.cpf LIKE :cpfColaborador AND m.dataHoraMarcacao >= :dataInicial AND m.dataHoraMarcacao <= :dataFinal" +
            ") ")
    List<Marcacao> buscaMarcacaoPorData(LocalDateTime dataInicial, LocalDateTime dataFinal, String cpfColaborador);
}

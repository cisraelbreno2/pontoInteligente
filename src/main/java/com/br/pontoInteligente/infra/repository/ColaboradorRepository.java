package com.br.pontoInteligente.infra.repository;

import com.br.pontoInteligente.domain.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long>{

    @Query("SELECT c.nome FROM Colaborador c WHERE c.cpf = ?1")
    String buscaNomeColaboradorPorCpf(String cpfColaborador);
}

package com.br.pontoInteligente.infra.repository;

import com.br.pontoInteligente.domain.model.MarcacaoTipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcacaoTipoRepository extends JpaRepository<MarcacaoTipo, Long> {
}

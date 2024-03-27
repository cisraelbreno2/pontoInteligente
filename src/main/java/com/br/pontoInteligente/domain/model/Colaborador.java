package com.br.pontoInteligente.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "COLABORADOR")
public class Colaborador {

    @Id
    @Column(name = "CPF", nullable = false)
    private String cpf;

    @Column(name = "NOME", nullable = false)
    private String nome;
}
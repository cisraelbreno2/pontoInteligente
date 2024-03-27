package com.br.pontoInteligente.infra.controller;

import com.br.pontoInteligente.domain.dto.RelatorioDTO;
import com.br.pontoInteligente.domain.exception.standard.StandardRestHandler;
import com.br.pontoInteligente.domain.useCase.GeraDadosRelatorioPontoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relatorio")
@RequiredArgsConstructor
public class RelatorioController extends StandardRestHandler {

    private final GeraDadosRelatorioPontoPort geraDadosRelatorioPontoPort;

    @GetMapping("/relatorioPonto")
    public ResponseEntity<RelatorioDTO> geraRelatorioPonto(@RequestParam String dataInicio, @RequestParam String dataFim, @RequestParam String cpfColaborador) {
        return new ResponseEntity<>(geraDadosRelatorioPontoPort.geraRelatorio(dataInicio, dataFim, cpfColaborador), HttpStatus.OK);
    }

}

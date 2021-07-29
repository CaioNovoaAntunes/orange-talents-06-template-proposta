package com.br.proposta.controller;

import com.br.proposta.modelo.ConsultaPropostaResponse;
import com.br.proposta.modelo.Proposta;
import com.br.proposta.repositorios.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DetalhesPropostaController {

    @Autowired
    PropostaRepository propostaRepository;

    @GetMapping("/proposta/{id}")
    public ResponseEntity<?> detalhesProposta(@PathVariable String id) {
        Long idProposta = Long.parseLong(id);
        Proposta proposta = propostaRepository.findById(idProposta)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Não existe proposta com este id: " + id));
        return ResponseEntity.ok(new ConsultaPropostaResponse(proposta));
    }
}

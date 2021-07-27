package com.br.proposta.modelo;

import com.br.proposta.analise.AnalisaCliente;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;


@RestController
public class PropostaController {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private AnalisaCliente analise;

    @GetMapping("/proposta/{id}")
    public ResponseEntity<?> detalhesProposta(@PathVariable String id) {
        Long idProposta = Long.parseLong(id);
        Proposta proposta = propostaRepository.findById(idProposta)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Não existe proposta com este id: " + id));
        return ResponseEntity.ok(new ConsultaPropostaResponse(proposta.getNome(),proposta.getStatus()));
    }





    @PostMapping("/proposta")
    @Transactional
    public ResponseEntity<?> cadastrarProposta(@RequestBody @Valid NovaPropostaRequest request, UriComponentsBuilder uriComponentsBuilder){

        Proposta proposta = request.conversor();
        propostaRepository.save(proposta);
        proposta.setaStatus(analise);
        propostaRepository.save(proposta);
        return ResponseEntity.created(uriComponentsBuilder.path("/proposta/{id}")
                .buildAndExpand(proposta.getId()).toUri()).build();
    }
}
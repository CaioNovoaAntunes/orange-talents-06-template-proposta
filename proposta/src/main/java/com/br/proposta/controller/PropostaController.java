package com.br.proposta.controller;

import com.br.proposta.integracoes.AnalisaCliente;
import com.br.proposta.modelo.NovaPropostaRequest;
import com.br.proposta.modelo.Proposta;
import com.br.proposta.repositorios.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;




    @RestController
    public class PropostaController {

        @Autowired
        private PropostaRepository propostaRepository;

        @Autowired
        private AnalisaCliente analise;

        @PostMapping("/proposta")
        @Transactional
        public ResponseEntity<?> cadastrarProposta(@RequestBody @Valid NovaPropostaRequest request, UriComponentsBuilder uriComponentsBuilder) {

            Proposta proposta = request.conversor();
            propostaRepository.save(proposta);
            proposta.setaStatus(analise);
            propostaRepository.save(proposta);
            return ResponseEntity.created(uriComponentsBuilder.path("/proposta/{id}")
                    .buildAndExpand(proposta.getId()).toUri()).build();
        }
    }

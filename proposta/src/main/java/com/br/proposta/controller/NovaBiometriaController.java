package com.br.proposta.controller;

import com.br.proposta.dto.NovaBiometriaRequest;
import com.br.proposta.integracoes.AssociaCartao;
import com.br.proposta.modelo.biometria.Biometria;
import com.br.proposta.repositorios.BiometriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;


@RestController
public class NovaBiometriaController {
    @Autowired
    BiometriaRepository biometriaRepository;
    @Autowired
    AssociaCartao associaCartao;

    @PostMapping("/biometria/{numberCard}")
    @Transactional
    public ResponseEntity<?> save(@PathVariable String numberCard, @Valid @RequestBody NovaBiometriaRequest request) {
        boolean existsBiometria = biometriaRepository.findByImpressaoDigital(request.getImpressaoDigital()).isPresent();
        if (!existsBiometria) {
            associaCartao.findByNumberCard(numberCard);
            Biometria saved = biometriaRepository.save(new Biometria(request.getImpressaoDigital(), numberCard));
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{numberCard}/")
                    .buildAndExpand(saved.getId())
                    .toUri();
            return ResponseEntity.created(uri).build();
        }
        return ResponseEntity.badRequest().body(new RuntimeException("não funciono"));
    }
}
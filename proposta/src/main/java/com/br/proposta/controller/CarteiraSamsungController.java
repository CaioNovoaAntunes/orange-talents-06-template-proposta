package com.br.proposta.controller;


import com.br.proposta.dto.CarteiraSamsungRequest;
import com.br.proposta.integracoes.CriaCarteira;
import com.br.proposta.modelo.CarteiraSamsung;
import com.br.proposta.modelo.Proposta;
import com.br.proposta.modelo.carteiras.CarteiraPaypal;
import com.br.proposta.repositorios.CarteiraSamsungRepository;
import com.br.proposta.repositorios.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Map;
import java.util.Optional;

@RestController
public class CarteiraSamsungController {

    @Autowired
    CarteiraSamsungRepository carteiraSamsungRepository;

    @Autowired
    CriaCarteira criaCarteira;

    @Autowired
    PropostaRepository propostaRepository;

    @PostMapping("/carteiras/samsung/{id}")
    @Transactional
    public ResponseEntity<?> associaCarteiraSamsung(@PathVariable String id, @RequestBody @Valid CarteiraSamsungRequest request){
        Optional<Proposta> possivelCartao = propostaRepository.findByNumeroCartao(id);
        Optional<CarteiraSamsung> existeCarteira = carteiraSamsungRepository.findByNumeroCartao(id);
        if (possivelCartao.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Cartão não encontrado");
        }
        if(existeCarteira.isPresent()){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        CarteiraSamsung carteiraSamsung = request.conversor(id);
        criaCarteira.carteiras(id, Map.of(
                "email", request.getEmail(),
                "carteira", request.getCarteira()));
        carteiraSamsungRepository.save(carteiraSamsung);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(carteiraSamsung.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
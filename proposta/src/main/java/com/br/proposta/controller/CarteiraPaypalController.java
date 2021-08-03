package com.br.proposta.controller;

import com.br.proposta.dto.CarteiraRequest;
import com.br.proposta.integracoes.CriaCarteira;
import com.br.proposta.modelo.Proposta;
import com.br.proposta.modelo.carteiras.CarteiraPaypal;
import com.br.proposta.repositorios.CarteiraPaypalRepository;
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
public class CarteiraPaypalController {

    @Autowired
    CarteiraPaypalRepository carteiraPaypalRepository;

    @Autowired
    CriaCarteira criaCarteira;

    @Autowired
    PropostaRepository propostaRepository;

    @PostMapping("/carteiras/paypal/{id}")
    @Transactional
    public ResponseEntity<?> associaCarteira(@PathVariable String id, @RequestBody @Valid CarteiraRequest request){
        Optional<Proposta> possivelCartao = propostaRepository.findByNumeroCartao(id);
        Optional<CarteiraPaypal> existeCarteira = carteiraPaypalRepository.findByNumeroCartao(id);
        if (possivelCartao.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Cartão não encontrado");
        }
        if(existeCarteira.isPresent()){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        CarteiraPaypal carteiraPaypal = request.conversor(id);
        criaCarteira.paypal(id, Map.of(
                "email", request.getEmail(),
                "carteira", request.getCarteira()));
        carteiraPaypalRepository.save(carteiraPaypal);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(carteiraPaypal.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
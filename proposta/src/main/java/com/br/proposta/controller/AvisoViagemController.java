package com.br.proposta.controller;

import com.br.proposta.dto.AvisoViagemRequest;
import com.br.proposta.dto.CartaoResponse;
import com.br.proposta.integracoes.AssociaCartao;
import com.br.proposta.modelo.AvisoViagem;
import com.br.proposta.repositorios.AvisoViagemRepository;
import feign.FeignException;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class AvisoViagemController {

    @Autowired
    AvisoViagemRepository avisoViagemRepository;

    @Autowired
    AssociaCartao associaCartao;


    @PostMapping("/avisoviagem/{id}")
    @Transactional
    public ResponseEntity<?> cadastraAviso(@PathVariable String id, @RequestBody @Valid AvisoViagemRequest request, @RequestHeader(value = "User-Agent") String userAgent, HttpServletRequest httpRequest) {
        Optional<CartaoResponse> cartao = Optional.ofNullable(associaCartao.findByNumberCard(id));
        if (cartao == null) {
            return ResponseEntity.notFound().build();

        }
        associaCartao.enviaAvisoViagem(id,request);
        AvisoViagem avisoViagem = request.conversor(id, httpRequest.getRemoteAddr(), userAgent);
        avisoViagemRepository.save(avisoViagem);


        return ResponseEntity.ok().build();
    }

}






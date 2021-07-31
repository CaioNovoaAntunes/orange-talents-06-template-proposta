package com.br.proposta.controller;


import com.br.proposta.dto.CartaoResponse;
import com.br.proposta.integracoes.AssociaCartao;
import com.br.proposta.integracoes.BloqueioCartao;
import com.br.proposta.modelo.Bloqueio;
import com.br.proposta.repositorios.BloqueioRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;


@RestController
public class BloqueioController {

    @Autowired
    BloqueioRepository bloqueioRepository;

    @Autowired
    AssociaCartao associaCartao;

    @Autowired
    BloqueioCartao bloqueioCartao;

    private String sistemaResponsavel = "Api-Proposta";

    @PostMapping("/cartoes/{id}/bloqueio")
    @Transactional
    ResponseEntity<?> bloquearCartao(@PathVariable String id, @RequestHeader(value = "User-Agent") String userAgent, HttpServletRequest request) {

        CartaoResponse cartao = associaCartao.findByNumberCard(id);
        Map<String, Object> nomeSistema = new HashMap<>();
        nomeSistema.put("sistemaResponsavel", this.sistemaResponsavel);
        bloqueioCartao.bloquearCartao(id, nomeSistema);

        Bloqueio bloqueio = new Bloqueio(request.getRemoteAddr(), userAgent, id);
        bloqueioRepository.save(bloqueio);

        return ResponseEntity.ok().build();
    }
}
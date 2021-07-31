package com.br.proposta.integracoes;

import com.br.proposta.dto.CartaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "${cartoes.url}", name = "bloqueioCartao")
public interface BloqueioCartao {

    @GetMapping("/{id}")
    CartaoResponse getCartao(@PathVariable String id);

    /*    @CircuitBreaker(name = "bloquearCartao", fallbackMethod = "analiseFallback")*/
    @PostMapping("/{id}/bloqueios")
    void bloquearCartao(@PathVariable String id, Object sistemaResponsavel);



}
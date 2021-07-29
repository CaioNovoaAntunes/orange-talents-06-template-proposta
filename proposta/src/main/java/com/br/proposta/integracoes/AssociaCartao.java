package com.br.proposta.integracoes;

import com.br.proposta.dto.CartaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "associa",
        url = "${cargoes.url}")
public interface AssociaCartao {

    @GetMapping
    CartaoResponse buscaCartao(@RequestParam(required = true, name = "idProposta") String id);

    @GetMapping("/{id}")
    CartaoResponse findByNumberCard(@PathVariable String id);

}

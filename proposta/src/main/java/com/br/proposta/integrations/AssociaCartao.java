package com.br.proposta.integrations;

import com.br.proposta.dto.CartaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "associa",
        url = "${cartoes.url}")
public interface AssociaCartao {

    @GetMapping
    CartaoResponse buscaCartao(@RequestParam(required = true, name = "idProposta") String id);

}
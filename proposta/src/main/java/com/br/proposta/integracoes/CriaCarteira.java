package com.br.proposta.integracoes;

import com.br.proposta.dto.CarteiraReponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "paypal",
        url = "${cartoes.url}")
public interface CriaCarteira {

    @PostMapping("/{id}/carteiras")
    CarteiraReponse paypal(@PathVariable String id, @RequestBody Map<String, Object> request);
}
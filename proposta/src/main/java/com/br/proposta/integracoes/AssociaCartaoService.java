package com.br.proposta.integracoes;

import com.br.proposta.dto.CartaoResponse;
import org.springframework.web.bind.annotation.RequestParam;

public class AssociaCartaoService implements  AssociaCartao{
    @Override
    public CartaoResponse buscaCartao(@RequestParam(required = true, name = "idProposta") String id) {
        return null;
    }

    @Override
    public CartaoResponse findByNumberCard(String id) {
        return null;
    }
}
package com.br.proposta.integracoes;

import com.br.proposta.dto.CartaoResponse;

public class BloqueioCartaoService implements BloqueioCartao{
    @Override
    public CartaoResponse getCartao(String id) {
        return null;
    }

    @Override
    public void bloquearCartao(String id, Object sistemaResponsavel) {

    }
}
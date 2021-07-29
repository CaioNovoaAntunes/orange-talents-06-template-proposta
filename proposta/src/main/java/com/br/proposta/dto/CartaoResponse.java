package com.br.proposta.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

public class CartaoResponse {

    @JsonProperty("id")
    private String numeroCartao;

    @JsonCreator(mode = Mode.PROPERTIES)
    public CartaoResponse(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    @Override
    public String toString() {
        return "CartaoResponse{" +
                "numeroCartao='" + numeroCartao + '\'' +
                '}';
    }
}

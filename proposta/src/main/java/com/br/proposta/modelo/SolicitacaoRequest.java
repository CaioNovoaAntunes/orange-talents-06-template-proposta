package com.br.proposta.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolicitacaoRequest {

    private String documento;
    private String nome;
    @JsonProperty("idProposta")
    private Long idProposta;

    public SolicitacaoRequest(String documento, String nome, Long id) {
        this.documento = documento;
        this.nome = nome;
        this.idProposta = id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return idProposta;
    }

    @Override
    public String toString() {
        return "SolicitacaoRequest{" +
                "documento='" + documento + '\'' +
                ", nome='" + nome + '\'' +
                ", idProposta=" + idProposta +
                '}';
    }
}
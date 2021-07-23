package com.br.proposta.modelo;

import com.br.proposta.status.StatusSolicitacao;
import com.br.proposta.validation.NotExists;

public class NovaPropostaResponse {

    private StatusSolicitacao resultadoSolicitacao;

    public NovaPropostaResponse() { }

    public NovaPropostaResponse(StatusSolicitacao resultadoSolicitacao) {
        this.resultadoSolicitacao = resultadoSolicitacao;
    }
    public StatusSolicitacao getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

}